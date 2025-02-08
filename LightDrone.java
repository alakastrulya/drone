public class LightDrone extends Drone{
    private double speed;
    private double flightRange;

    LightDrone(){}

    LightDrone(String id,String status, double cargoCapacity, double currentCargoWeight,double speed){
        super(id,status,cargoCapacity,currentCargoWeight);
        this.speed=speed;
        this.flightRange=50000.0;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setFlightRange(double flightRange) {
        this.flightRange = flightRange;
    }

    @Override
    public String calculateFlightTime(double distance) {
        double totalHours = distance / speed;

        int days = (int) totalHours / 24;
        int hours = (int) totalHours % 24;
        int minutes = (int) ((totalHours % 1) * 60);

        return days + " days, " + hours + " hours, " + minutes + " minutes.";
    }

    public void stringToDrone(){
        System.out.println("ID: "+getId()+", Capacity: "+getCargoCapacity()+", Current weight: "+getCurrentCargoWeight()+", Speed: "+getSpeed());
    }
}

