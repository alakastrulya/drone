// author: Aisha
// date: 7.02.2025

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // User input, new drone

        Planet mercury = new Planet("mercury",800.0,700.0,"Exosphere");
        Planet earth = new Planet("earth",10.0,0.0,"Biosphere");
        SpaceStation MKS = new SpaceStation("MKS",36.4,96.6,145);


        LightDrone usersDrone1 = new LightDrone();
        HeavyDrone usersDrone2 = new HeavyDrone();
        String nameOfOurDestination = "";

        System.out.println("Which type of drone do you wanna choose?(light/heavy)");
        System.out.println("the only difference is that the flight range of the light drone is greater (50000.0) while the heavy one is less(20000.0)");
        String userr = in.nextLine();
        if(userr.equalsIgnoreCase("light")){
            System.out.println("Can you write new ID (String) for your Drone?");
            String userId = in.nextLine();
            System.out.println("Can you write capacity for your Drone?(it should be double and less than 3.1, like 2.9 and etc.)");
            String userInput1 = in.nextLine().replace(',', '.'); // Заменяем запятую на точку
            double userCapacity = Double.parseDouble(userInput1);


            System.out.println("Can you write current weight in your Drone?(also like 1.0, it should be less then capacity)");
            String userInput2 = in.nextLine().replace(',', '.'); // Заменяем запятую на точку
            double userWeight = Double.parseDouble(userInput2);

            System.out.println("How much speed do you want for your drone?(also like double 20.0)");
            String userInput4 = in.nextLine().replace(',', '.'); // Заменяем запятую на точку
            double userSpeed = Double.parseDouble(userInput4);


            // add new parameters into user's drone
            usersDrone1.setId(userId);
            usersDrone1.setCargoCapacity(userCapacity);
            usersDrone1.setCurrentCargoWeight(userWeight);
            usersDrone1.setSpeed(userSpeed);

            System.out.println("All information about your drone:");
            usersDrone1.stringToDrone();
            System.out.println();

            Cargo cargo = new Cargo();

            System.out.println("You need to add your cargo.Please write weight for it(just like 1 or 2 and etc.)");
            int cargoWeight = in.nextInt();
            in.nextLine();
            System.out.println("Please write mini description for your cargo type (like food, accessories)");
            String description = in.nextLine();

            cargo.setWeight(cargoWeight);
            cargo.setDescription(description);
            System.out.println("Information about your cargo");
            cargo.toStringCargo();

            System.out.println("Which destination do you want to choose?(mercury/MKS)");
            String destination = in.nextLine();
            if(destination.equalsIgnoreCase("mercury")){
                mercury.showDetails();
                DeliveryTask task1 = new DeliveryTask(earth,mercury,cargo);
                if (task1.assignDrone(usersDrone1)){
                    earth.distanceTo(mercury);
                    nameOfOurDestination="mercury";
                    task1.completeDelivery();
                }else{
                    System.out.println("Error!");
                }
            }else if(destination.equalsIgnoreCase("MKS")){
                MKS.showDetails();
                DeliveryTask task1 = new DeliveryTask( earth,  MKS, cargo);
                if (task1.assignDrone(usersDrone1)){
                    earth.distanceTo(MKS);
                    nameOfOurDestination="MKS";
                    task1.completeDelivery();
                }else{
                    System.out.println("Error!");
                }
            }else{
                System.out.println("Undefined place");
            }
            System.out.println("Do you want to calculate the arrival time for this distance?(please write true or false)");
            boolean distance = in.nextBoolean();
            in.nextLine(); // Очищаем буфер
            if(distance){
                if(nameOfOurDestination.equalsIgnoreCase("mercury")){
                    double distances = earth.distanceTo(mercury);
                    System.out.println("The Flight time with your distance gonna be: ");
                    System.out.println(usersDrone1.calculateFlightTime(distances));
                } else if (nameOfOurDestination.equalsIgnoreCase("MKS")) {
                    double distances = earth.distanceTo(MKS);
                    System.out.println("The Flight time with your distance gonna be: ");
                    System.out.println(usersDrone1.calculateFlightTime(distances));
                }else {
                    System.out.println("Sorry! It seems like we have some problems");
                }
            }
            System.out.println();

            usersDrone1.stringToDrone();
                System.out.println("Do you wanna add more weight?(please write true or false)");
                boolean add = in.nextBoolean();
                in.nextLine(); // очищаем буфер
                if(add){
                    System.out.println("Write weight in double that you wanna add(like 0.5 and etc.)");
                    String userInput3 = in.nextLine().replace(',', '.');
                    double userNewWeight = Double.parseDouble(userInput3);
                    usersDrone1.setCurrentCargoWeight(userWeight+userNewWeight);
                    System.out.println("The Updated details about your drone:");
                    usersDrone1.stringToDrone();
                }

            else{
                System.out.println("We don't have enough place for it");
            }
            System.out.println();


            System.out.println("If you want, we can check the opportunity to unload our drone (that is, if it is empty, please write true or false)");
            boolean answer = in.nextBoolean();
            in.nextLine(); // Очищаем буфер
            if(answer){
                usersDrone1.unloadCargo();
            }
        }else {
            System.out.println("Can you write new ID (String) for your Drone?");
            String userId = in.nextLine();
            System.out.println("Can you write capacity for your Drone?(it should be double and less than 3.1, like 2.9 and etc.)");
            String userInput1 = in.nextLine().replace(',', '.'); // Заменяем запятую на точку
            double userCapacity = Double.parseDouble(userInput1);


            System.out.println("Can you write current weight in your Drone?(also like 1.0, it should be less then capacity)");
            String userInput2 = in.nextLine().replace(',', '.'); // Заменяем запятую на точку
            double userWeight = Double.parseDouble(userInput2);

            System.out.println("How much speed do you want for your drone?(also like double 20.0)");
            String userInput4 = in.nextLine().replace(',', '.'); // Заменяем запятую на точку
            double userSpeed = Double.parseDouble(userInput4);


            // add new parameters into user's drone
            usersDrone2.setId(userId);
            usersDrone2.setCargoCapacity(userCapacity);
            usersDrone2.setCurrentCargoWeight(userWeight);
            usersDrone2.setSpeed(userSpeed);

            System.out.println("All information about your drone:");
            usersDrone2.stringToDrone();
            System.out.println();

            Cargo cargo1 = new Cargo();

            System.out.println("You need to add your cargo.Please write weight for it(just like 1 or 2 and etc.)");
            int cargoWeight = in.nextInt();
            in.nextLine();
            System.out.println("Please write mini description for your cargo type (like food, accessories)");
            String description = in.nextLine();

            cargo1.setWeight(cargoWeight);
            cargo1.setDescription(description);
            System.out.println("Information about your cargo");
            cargo1.toStringCargo();

            System.out.println("Which destination do you want to choose?(mercury/MKS)");
            String destination = in.nextLine();
            if(destination.equalsIgnoreCase("mercury")){
                mercury.showDetails();
                DeliveryTask task1 = new DeliveryTask(earth,mercury,cargo1);
                if (task1.assignDrone(usersDrone2)){
                    earth.distanceTo(mercury);
                    nameOfOurDestination="mercury";
                    task1.completeDelivery();
                }else{
                    System.out.println("Error!");
                }
            }else if(destination.equalsIgnoreCase("MKS")){
                MKS.showDetails();
                DeliveryTask task1 = new DeliveryTask( earth,  MKS, cargo1);
                if (task1.assignDrone(usersDrone2)){
                    earth.distanceTo(MKS);
                    nameOfOurDestination="MKS";
                    task1.completeDelivery();
                }else{
                    System.out.println("Error!");
                }
            }else{
                System.out.println("Undefined place");
            }
            System.out.println("Do you want to calculate the arrival time for this distance?(please write true or false)");
            boolean distance = in.nextBoolean();
            in.nextLine(); // Очищаем буфер
            if(distance){
                if(nameOfOurDestination.equalsIgnoreCase("mercury")){
                    double distances = earth.distanceTo(mercury);
                    System.out.println("The Flight time with your distance gonna be: ");
                    System.out.println(usersDrone2.calculateFlightTime(distances));
                } else if (nameOfOurDestination.equalsIgnoreCase("MKS")) {
                    double distances = earth.distanceTo(MKS);
                    System.out.println("The Flight time with your distance gonna be: ");
                    System.out.println(usersDrone2.calculateFlightTime(distances));
                }else {
                    System.out.println("Sorry! It seems like we have some problems");
                }
            }
            System.out.println();

            usersDrone2.stringToDrone();
            System.out.println("Do you wanna add more weight?(please write true or false)");
            boolean add = in.nextBoolean();
            in.nextLine(); // очищаем буфер
            if(add){
                System.out.println("Write weight in double that you wanna add(like 0.5 and etc.)");
                String userInput3 = in.nextLine().replace(',', '.');
                double userNewWeight = Double.parseDouble(userInput3);
                usersDrone2.setCurrentCargoWeight(userWeight+userNewWeight);
                System.out.println("The Updated details about your drone:");
                usersDrone2.stringToDrone();
            }

            else{
                System.out.println("We don't have enough place for it");
            }
            System.out.println();



            System.out.println("If you want, we can check the opportunity to unload our drone (that is, if it is empty, please write true or false)");
            boolean answer = in.nextBoolean();
            in.nextLine();
            if(answer){
                usersDrone2.unloadCargo();
            }

        }






    }
}