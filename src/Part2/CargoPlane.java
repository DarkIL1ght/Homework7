package Part2;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id, TowerMediator mediator, int fuelLevel) {
        super(id, mediator, fuelLevel);    }

    @Override
    public void receive(String msg) {
        System.out.printf("[CargoPlane %s] Received: %s%n", id, msg);
    }
}