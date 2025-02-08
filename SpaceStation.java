public class SpaceStation extends CelestialBody{
    private int stationLevel;

    SpaceStation(){}

    SpaceStation(String name, double coordinateX, double coordinateY,int stationLevel){
        super(name,coordinateX,coordinateY);
        this.stationLevel=stationLevel;
    }

    public int getStationLevel() {
        return stationLevel;
    }

    public void setStationLevel(int stationLevel) {
        this.stationLevel = stationLevel;
    }

    @Override
    public void showDetails(){
        System.out.println("Name: "+getName()+", Coordinate X: "+getCoordinateX()+", Coordinate Y: "+getCoordinateY()+", Station level: "+getStationLevel()+".");
    }
}
