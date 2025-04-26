package Part2;

public interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestLanding(Aircraft aircraft);
    boolean requestTakeOff(Aircraft aircraft);
    void handleEmergency(Aircraft emergencyAircraft);
}
