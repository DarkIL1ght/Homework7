package Part2;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, TowerMediator mediator, int fuelLevel) {
        super(id, mediator, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.printf("[PassengerPlane %s] Received: %s%n", id, msg);
    }
}