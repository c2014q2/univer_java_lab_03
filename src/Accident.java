import java.util.Random;
import java.util.Scanner;
public class Accident {

    int pret;

    public Accident() {
        Random rand = new Random();
        pret = rand.nextInt(10000)+50;
    }

    public Accident(int pret) {
        this.pret = pret;
    }

    public void print(){
        System.out.println(pret+"$");
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }


}