package main.training.Java;

class Vehicle{

    private String brand_name;
    private String model;
    private String color;

    public Vehicle(String brand_name,String model, String color){
        this.brand_name= brand_name;
        this.model = model;
        this.color = color;
    }


    public void getInfo(){
        System.out.println("brand_name" + brand_name);
        System.out.println("model" + model);
        System.out.println("color" + color);
    }
}


public class VehicleMain {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("proton","xl","red");
        v1.getInfo();

    }


}
