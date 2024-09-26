import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //System.out.printf("Hello and welcome!");

        Automobil car= new Automobil();

        car.setNume("Skoda");
        car.setAn(2008);
        car.setAccidente(3);
        car.setCostAccident(1444,0);
        car.setCostAccident(233,1);
        car.setCostAccident(333,2);
         car.printInfo();
    }

}