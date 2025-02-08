// author: Aisha
// date: 7.02.2025

abstract class Drone {
    private String id;
    private double cargoCapacity;
    private double currentCargoWeight;
    private String status;

    public Drone(){}

    public Drone(String id,String status, double cargoCapacity, double currentCargoWeight){
        this.id=id;
        this.cargoCapacity = cargoCapacity;
        this.currentCargoWeight=currentCargoWeight;
        this.status="inactive";

    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public double getCurrentCargoWeight() {
        return currentCargoWeight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCargoCapacity(double cargoCapacity) {
        if(cargoCapacity<100.1 && cargoCapacity>0.0){
            this.cargoCapacity = cargoCapacity;}
        else{
            throw new IllegalArgumentException("You cannot add capacity more than 2.0!");}
    }

    public void setCurrentCargoWeight(double currentCargoWeight) {
        if(getCargoCapacity()-currentCargoWeight>=0.0){
        this.currentCargoWeight = currentCargoWeight;}
        else{
            throw new IllegalArgumentException("You cannot add weight more than capacity!");
    }}

    //OVERLOADING EXAMPLE

    public String calculateFlightTime(int distance){
        double totalHours = Double.valueOf(distance) / 200.0;

        int days = (int) totalHours / 24;
        int hours = (int) totalHours % 24;
        int minutes = (int) ((totalHours % 1) * 60);

        return days + " days, " + hours + " hours, " + minutes + " minutes.";
    }

    public String calculateFlightTime(double distance) {
        double totalHours = distance / 200.0;

        int days = (int) totalHours / 24;
        int hours = (int) totalHours % 24;
        int minutes = (int) ((totalHours % 1) * 60);

        return days + " d " + hours + " h " + minutes + " m";
    }

//  можно ли добавить вес в карго(проверяем, вместиться ли еще груза?)
    public boolean loadCargo(double weight){
        double total = weight +currentCargoWeight;
        if((cargoCapacity-total)>=0){
            return true;
        }
        return false;
    }

    // проверяем, не пустой ли карго (то есть можно ли его разгрузить?)
    public void unloadCargo(){
        if(currentCargoWeight!=0){
            System.out.println("We can unload our Cargo!");
        }
        else{System.out.println("We can't unload our Cargo!");}
    }

    public void stringToDrone(){
        System.out.println("ID: "+getId()+", Capacity: "+getCargoCapacity()+", Current weight: "+getCurrentCargoWeight());
    }
}

