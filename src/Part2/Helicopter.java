package Part2;

public class Helicopter extends Aircraft {
    public Helicopter(String id, TowerMediator mediator, int fuelLevel) {
        super(id, mediator, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.printf("[Helicopter %s] Received: %s%n", id, msg);
    }
}