// author: Aisha
// date: 7.02.2025

public class DeliveryTask {
    private CelestialBody origin;
    private CelestialBody destination;
    private Cargo cargo;
    private Drone assignedDrone;
    private boolean deliveryComplete;// добавленный параметр

    DeliveryTask(){}

    DeliveryTask(CelestialBody origin, CelestialBody destination, Cargo cargo){
        this.origin=origin;
        this.destination=destination;
        this.cargo=cargo;
        this.assignedDrone=null;
        this.deliveryComplete=false;
    }

    public CelestialBody getOrigin() {
        return origin;
    }

    public CelestialBody getDestination() {
        return destination;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Drone getAssignedDrone() {
        return assignedDrone;
    }

    public void setOrigin(CelestialBody origin) {
        this.origin = origin;
    }

    public void setDestination(CelestialBody destination) {
        this.destination = destination;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setAssignedDrone(Drone assignedDrone) {
        this.assignedDrone = assignedDrone;
    }

    public boolean isDeliveryComplete() {
        return deliveryComplete;
    }

    public void setDeliveryComplete(boolean deliveryComplete) {
        this.deliveryComplete = deliveryComplete;
    }

    public boolean assignDrone(Drone drone){
        if(drone.getCargoCapacity()- drone.getCurrentCargoWeight()- cargo.getWeight()>=0.0){
            System.out.println("Drone: "+drone.getId()+" assigned on this task.");
            drone.setCurrentCargoWeight(drone.getCurrentCargoWeight()+ cargo.getWeight());
            this.assignedDrone=drone;
            drone.setStatus("IN_FLIGHT");
            return true;
        }else{
            System.out.println("Weight is too heavy for this drone.");
            this.assignedDrone=null;
            return false;
        }
    }


    public void completeDelivery(){
        if(assignedDrone==null){
            System.out.println("No drone assigned to this task");
        }
        if(assignedDrone.getStatus().equals("IN_FLIGHT")){
            assignedDrone.setCurrentCargoWeight(assignedDrone.getCurrentCargoWeight() - cargo.getWeight());
            assignedDrone.setStatus("IDLE");
            deliveryComplete = true;
        System.out.println("Delivery completed to: ");
        System.out.println("Coordinate X: "+getDestination().getCoordinateX()+", Coordinate Y: "+getDestination().getCoordinateY());
    }else{
        System.out.println("Error! This drone isn't in flight");
    }}
}
