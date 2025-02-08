import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


abstract class CelestialBody {
    private String name;
    private double coordinateX;
    private double coordinateY;

    CelestialBody(){}

    CelestialBody(String name,double coordinateX,double coordinateY){
        this.name=name;
        this.coordinateX=coordinateX;
        this.coordinateY=coordinateY;
    }

    public String getName() {
        return name;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double distanceTo(CelestialBody other){
        return sqrt(pow((other.coordinateX-getCoordinateX()),2)+pow((other.coordinateY-getCoordinateY()),2));
    }

    public void showDetails(){
        System.out.println("Name: "+getName()+", Coordinate X: "+getCoordinateX()+", Coordinate Y: "+getCoordinateY()+".");
    }
}
