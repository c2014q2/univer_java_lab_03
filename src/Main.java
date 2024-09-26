import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //System.out.printf("Hello and welcome!");

        Automobil car= new Automobil();
        Automobil car1= new Automobil("Porsche", 1992);
        Automobil car2= new Automobil("Toyota Supra");

        car.setRandomValues();
        car1.setAccidente(3);
        car1.setCostAccident(1200, 0);
        car1.setCostAccident(9900, 1);
        car1.setCostAccident(5670, 2);
       // car.setInfoFromKeyboard();

        Automobil[] cars = new Automobil[]{car, car1, car2};

        for (Automobil masina : cars) {
            
            masina.printInfo();
            masina.sumaReparatie();
            System.out.println("    ");
            System.out.println("    ");
        }
        
        car.compare(car2);
        Automobil.sumaReparatieAutomobile(car1, car);
    }

}