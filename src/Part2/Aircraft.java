package Part2;

public abstract class Aircraft {
    protected String id;
    protected TowerMediator mediator;
    protected int fuelLevel;
    protected boolean hasEmergency = false;

    public Aircraft(String id, TowerMediator mediator, int fuelLevel) {
        this.id = id;
        this.mediator = mediator;
        this.fuelLevel = fuelLevel;
    }

    public abstract void receive(String msg);

    public void send(String msg) {
        mediator.broadcast(msg, this);
    }

    public void updateFuel() {
        fuelLevel--;
        if (fuelLevel < 5 && !hasEmergency) {
            hasEmergency = true;
            send("MAYDAY");
        }
    }

    public boolean hasEmergency() {
        return hasEmergency;
    }

    public String getId() {
        return id;
    }
}