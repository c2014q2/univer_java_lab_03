import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //System.out.printf("Hello and welcome!");

        Automobil car= new Automobil("Skode Octavia",3,2004, new int[]{1200, 300, 500});
        Automobil car1= new Automobil("Toyota Prius",8,2000, new int[]{1200, 300, 500});
        //System.out.println(Automobil.sumaReparatieAutomobile(car, car1)+("$"));   pentru a testa metoda static

         // car.printInfo();
    }

}