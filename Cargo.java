public class Cargo {
    private int weight;
    private String description;

    Cargo(){}

    Cargo(int weight, String description){
        this.weight=weight;
        this.description=description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void toStringCargo(){
        System.out.println("Weight: "+getWeight()+", Description: "+getDescription());
    }
}
