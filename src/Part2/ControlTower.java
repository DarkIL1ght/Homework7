package Part2;

import java.util.*;

public class ControlTower implements TowerMediator {
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeOffQueue = new LinkedList<>();
    private boolean isRunwayAvailable = true;
    private Aircraft currentAircraft;

    @Override
    public synchronized boolean requestLanding(Aircraft aircraft) {
        if (aircraft.hasEmergency()) {
            landingQueue.add(aircraft);
            System.out.printf("[TOWER] Emergency landing priority for %s%n", aircraft.getId());
        } else {
            landingQueue.add(aircraft);
        }
        return processNextRequest();
    }

    @Override
    public synchronized boolean requestTakeOff(Aircraft aircraft) {
        takeOffQueue.add(aircraft);
        return processNextRequest();
    }

    private boolean processNextRequest() {
        if (!isRunwayAvailable) return false;

        if (!landingQueue.isEmpty()) {
            currentAircraft = landingQueue.poll();
            currentAircraft.receive("CLEARED TO LAND");
        } else if (!takeOffQueue.isEmpty()) {
            currentAircraft = takeOffQueue.poll();
            currentAircraft.receive("CLEARED TO TAKE OFF");
        } else {
            return false;
        }

        isRunwayAvailable = false;
        new Thread(() -> {
            try {
                Thread.sleep(3000); // Simulate runway operation
                isRunwayAvailable = true;
                processNextRequest();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        return true;
    }

    @Override
    public void handleEmergency(Aircraft emergencyAircraft) {
        landingQueue.clear();
        takeOffQueue.clear();
        if (currentAircraft != null) {
            currentAircraft.receive("HOLD: EMERGENCY IN PROGRESS");
        }
        landingQueue.add(emergencyAircraft);
        processNextRequest();
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if ("MAYDAY".equals(msg)) {
            System.out.printf("[TOWER] EMERGENCY! %s requests immediate landing!%n", sender.getId());
            handleEmergency(sender);
        }
    }
}