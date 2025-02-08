public class Planet extends CelestialBody{
    private String atmosphereType;

    Planet(){}

    Planet(String name, double coordinateX, double coordinateY, String atmosphereType){
        super(name,coordinateX,coordinateY);
        this.atmosphereType=atmosphereType;
    }

    public String getAtmosphereType() {
        return atmosphereType;
    }

    public void setAtmosphereType(String atmosphereType) {
        this.atmosphereType = atmosphereType;
    }

    @Override
    public void showDetails(){
        System.out.println("Name: "+getName()+", Coordinate X: "+getCoordinateX()+", Coordinate Y: "+getCoordinateY()+", Atmosphere Type: "+getAtmosphereType()+".");
    }
}
