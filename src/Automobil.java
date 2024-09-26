import java.util.Scanner;
import java.util.Random;

public class Automobil {
    private String nume;
    private int nr_accidente;
    private int[] accidente;
    private static int automobile;
   // private int costulAccidente[];
    private int anul;


    public Automobil() {
        nr_accidente = 0;
        nume = "null";
        //accidente = null;
        automobile++;
        anul = 2000;


    }

    public Automobil(String nume, int anul, int nr_accidente) {
        this.nume = nume;

        this.accidente = new int[nr_accidente];
        this.nr_accidente = nr_accidente;
        this.anul = anul;
        automobile++;
    }

    public Automobil(String nume, int anul){
        this.nume = nume;

        this.anul = anul;
        automobile++;

    }

    public Automobil(String nume){
        this.nume = nume;
        automobile++;
    }

    public Automobil(Automobil a) {
        this.nume = a.nume;
        this.anul = a.anul;
        this.nr_accidente = a.nr_accidente;

        this.accidente = new int[a.accidente.length];
        for (int i = 0; i < a.accidente.length; i++) {
            this.accidente[i] = a.accidente[i];
        }
        automobile++;


    }



    public  void printInfo(){

        System.out.println("Total automobile: " + automobile);
        System.out.println("Nume: " + nume);
        System.out.println("Anul producerii: " + anul);


        if (accidente != null) {
            System.out.println("Accidente: " + accidente.length);
            for(int i=0;i<accidente.length;i++){
                System.out.println("  Accident nr"+(i+1)+" - "+accidente[i]+"$");
            }
        }
        else System.out.println("Automobilul nu are accidente");
    }
    //functia care seteaza tot de la tastatura

    public void setInfoFromKeyboard(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nume: ");
        nume = sc.next();
        do {
            System.out.print("Anul: ");
            anul = sc.nextInt();
        }
        while (anul <= 1885 || anul > 2024);
        nr_accidente = 0;
        do {
            System.out.print("Accidente: ");
            nr_accidente = sc.nextInt();
        }
        while (nr_accidente < 0 || nr_accidente > 50 );
        if (nr_accidente!=0){
            accidente = new int[nr_accidente];
            System.out.println("Urmeaza sa introduceti costul fiecarei reparatii ");
        }
        else {
                accidente = null;
        }

        int nr1 = 0;
        for(int i=0;i<nr_accidente;i++){
            do {
                System.out.println("Accidentul nr "+(i+1)+" : ");
                nr1 = sc.nextInt();
            }
            while (nr1 <= 0  );
            accidente[i]=nr1;
        }

    }


    public void setRandomValues()
    {
        Random rand = new Random();
        String[] numeRandom = new String[]{"Skoda", "Toyota", "Nissan"};
        nume = numeRandom[rand.nextInt(numeRandom.length)];
        anul = rand.nextInt(2024)+1885;
        nr_accidente = rand.nextInt(numeRandom.length);
        accidente = new int[nr_accidente];
        for(int i=0;i<accidente.length;i++){
            accidente[i] = rand.nextInt(10000)+50;
        }

    }


    public void compare(Automobil a){
        System.out.println(this.nume+(" --- ")+accidente+(" accidente") );
        System.out.println(a.nume+(" --- ")+a.accidente+(" accidente") );

    }

    public int sumaReparatie()
    {
        int sum = 0;
        if (accidente!=null)
        {
            for (int i = 0; i < accidente.length; i++) {
                sum += accidente[i];
            }
            System.out.println("Automobilul a fost reparat in suma de "+sum+("$"));
            return sum;
        }
        System.out.println("Masina nu a avut accidente");
        return 0;
    }

    public static int sumaReparatieAutomobile(Automobil a, Automobil b)
    {
        int sum = a.sumaReparatie() + b.sumaReparatie();
        return sum;
    }

    //Get() si Set()
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }
    public void setAn(int an) {
       if (an > 1500 && an < 2024)
        anul = an;
    }

    public int getAn() {
        return anul;
    }



    public int[] setAccidente(int accidenteTemp) {
        if (accidenteTemp >= 0 && accidenteTemp <= 50 && accidenteTemp != nr_accidente) {
            int[] oldAccidente = new int[nr_accidente];
                 for (int i = 0; i < nr_accidente; i++) {
                     oldAccidente[i] = accidente[i];
                 }
            accidente = new int[accidenteTemp];
            return oldAccidente;
            }
        return null;
        }


    public void setNr_accidente(int nr_accidente) {
        if ( nr_accidente >= 0 && nr_accidente <= 50 )
        this.nr_accidente = nr_accidente;
    }

    public int getNr_accidente(){
            return nr_accidente;
    }


    public int[] getAccidenteList() {
        return accidente;
    }


    public void setCostAccident (int cost, int index) {
        if (accidente != null) {
            if ((index >= 0) && (index < accidente.length) && (cost >= 0) && (cost <= 10000)) {
                accidente[index] = cost;
            }
        }
    }

    public int getCostAccident (int index) {
        return accidente[index];
    }
}


