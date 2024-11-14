import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Automobil {
    private static int automobile;

    private String nume;
    private int nr_accidente;
    private int probeg = 1;

    private ArrayList<Accident> accidente;

    // private int costulAccidente[];
    private int anul;



    private int accident_index = 0;


    public Automobil() {
        Random rand = new Random();
        String[] numeRandom = new String[]{"Skoda", "Toyota", "Nissan"};
        nume = numeRandom[rand.nextInt(numeRandom.length)];
        anul = rand.nextInt(139)+1885;
        probeg = rand.nextInt(1_000_000);

        nr_accidente = rand.nextInt(5);
        accidente = new ArrayList<Accident>();


        for(int i = 0; i<nr_accidente; i++){
            accidente.add(new Accident());
        }

        automobile++;
    }

    public Automobil(String nume, int anul, int nr_accidente) {
        this.nume = nume;

        this.accidente = new ArrayList<>(nr_accidente);
        for(int i = 0; i<nr_accidente; i++){
            accidente.add(new Accident());
        }
        this.nr_accidente = nr_accidente;
        this.anul = anul;
        automobile++;
    }

    public Automobil(String nume, int anul){
        this.nume = nume;
        Random rand = new Random();
        this.anul = anul;

        nr_accidente = rand.nextInt(5);
        accidente = new ArrayList<Accident>();


        for(int i = 0; i<nr_accidente; i++){
            accidente.add(new Accident());
        }

        automobile++;

    }



    public Automobil(Automobil a) {
        this.nume = a.nume;
        this.anul = a.anul;
        this.nr_accidente = a.nr_accidente;

        accidente = (ArrayList<Accident>) a.accidente.clone();


        automobile++;


    }



    public  void printInfo(){

        System.out.println("Total automobile: " + automobile);
        System.out.println("Nume: " + nume);
        System.out.println("Anul producerii: " + anul);
        System.out.println("Distanta parcursa: "+probeg+"km");


        if (!accidente.isEmpty()) {
            System.out.println("Accidente: " + accidente.size());
            int temp = 0;
            for(Accident acc : accidente){
                acc.print();
                temp++;
            }
        }
        else System.out.println("Automobilul nu are accidente");
    }
    //functia care seteaza tot de la tastatura

    public void setAllInfoFromKeyboard(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nume: ");
        nume = sc.next();

        inputAn();

        inputProbeg();

        inputNrAccidente();

    }

    public void inputAn() {                        //metoda standartda de abordare a exceptiilor
        Scanner sc = new Scanner(System.in);
        int ind = 0;
        boolean flag = false;

        System.out.println("Introdu anul producerii masinii:");
        do {
            flag = false;
            try{
                if (!sc.hasNextInt()) {
                    sc.nextLine();
                    throw new AutomobilException(-1, ind);
                }
                anul = sc.nextInt();
                if (anul <= 1885 || anul > 2024)
                {
                    throw new AutomobilException(anul, ind);
                }
            }
            catch (AutomobilException e){
                flag = true;
                e.handle();

            }
        }
        while (flag);
    }


    public void inputNrAccidente(){     //functia care prinde exeptiile din metoda lenesa
        boolean flag = false;
        do {
            flag = false;

            try {
                inputNrAccidenteTEST();
            }
            catch (AutomobilException e) {
                flag = true;
                e.handle();
            }
        }
        while (flag);


        do {
            flag = false;

            try {
                inputAccidenteTEST();
            }
            catch (AutomobilException e) {
                flag = true;
                e.handle();
            }
        }
        while (flag);

    }


    private void inputAccidenteTEST() throws AutomobilException {
        int ind = 2;
        Scanner sc = new Scanner(System.in);
        int temp;



        for (; accident_index < nr_accidente; accident_index++) {

            System.out.println("Introdu pretul accidentului Nr."+(accident_index+1));

            if (!sc.hasNextInt()) {

                throw new AutomobilException(-1, ind);
            }
            else {
                temp = sc.nextInt();
                if (temp <=0 ) {
                    throw new AutomobilException(temp, ind);
                }
                else {

                    accidente.add(new Accident(temp));
                }
            }
        }
        accident_index = 0;
    }


    private void inputNrAccidenteTEST() throws AutomobilException {               //metoda lenesa
        Scanner sc = new Scanner(System.in);
        int ind = 1;
        int temp;

        accidente.clear();

        System.out.println("Introdu Nr. de accidente:");



        if (!sc.hasNextInt()) {

            throw new AutomobilException(-1, ind);
        }
        else {

            nr_accidente = sc.nextInt();
            if (nr_accidente < 0 || nr_accidente > 50) {

                throw new AutomobilException(nr_accidente, ind);
            }
            else if (nr_accidente == 0) accidente.clear();

        }
    }

    public void inputProbeg()                                                //try in try
    {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        do{
            flag = false;
            int ind = 3;
            System.out.println("Introdu distanta parcursa a masinii: ");

            try {
                try {
                    probeg = sc.nextInt();

                    if (probeg <0 || probeg> 1_000_000){
                        throw new AutomobilException(probeg, ind);
                    }

                }
                catch (Exception e) {
                    if (e instanceof AutomobilException) throw new AutomobilException(probeg, ind);
                    else throw new AutomobilException(e);
                }

            }
            catch (AutomobilException e) {
                e.handle();
                flag = true;
                sc.nextLine();

            }

        } while (flag);

    }






    public void compare(Automobil a){
        System.out.println(this.nume+(" --- ")+nr_accidente+(" accidente") );
        System.out.println(a.nume+(" --- ")+a.nr_accidente+(" accidente") );

    }




    public int sumaReparatie()
    {
        int sum = 0;
        if (!accidente.isEmpty())
        {
            for (Accident acc : accidente) {
                sum += acc.getPret();
            }
            System.out.println("Automobilul "+nume+" a fost reparat in suma de "+sum+("$"));
            return sum;
        }
        System.out.println("Automobilul "+nume+" nu a fost reparat");
        return 0;
    }

    public static int sumaReparatieAutomobile(Automobil a, Automobil b)
    {
        return a.sumaReparatie() + b.sumaReparatie();
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

    public int getProbeg() {
        return probeg;
    }

    public void setProbeg(int probeg) {
        if (probeg >= 0 && probeg < 1_000_000) this.probeg = probeg;
    }

    public void setAccidente(ArrayList<Accident> accidenteTemp) {
        this.accidente = accidenteTemp;

    }

    public ArrayList<Accident> getAccidente() {
        return accidente;
    }




    public void setNr_accidente(int nr_accidente) {
        if ( nr_accidente >= 0 && nr_accidente <= 50 ) this.nr_accidente = nr_accidente;
    }

    public int getNr_accidente(){
        return nr_accidente;
    }








    public int getCostAccident (int index) {
        return (accidente.get(index)).getPret();
    }
}