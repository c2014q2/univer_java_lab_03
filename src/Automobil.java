import java.util.Scanner;
public class Automobil {
    private String nume;
    private int accidente;
    private static int automobile;
    private int costulAccidente[];
    private int anul;


    public Automobil() {

        costulAccidente = null;
        automobile++;

    }

    public Automobil(String nume,int accidente, int anul, int costulAccidente[]) {
        this.nume = nume;
        this.accidente = accidente;
        this.costulAccidente = new int[costulAccidente.length];
        this.costulAccidente = costulAccidente;
        this.anul = anul;
        automobile++;
    }

    public Automobil(String nume, int accidente, int anul){
        this.nume = nume;
        this.accidente = accidente;
        this.anul = anul;
        automobile++;

    }

    public Automobil(String nume, int anul){
        this.nume = nume;
    }

    public Automobil(Automobil a) {
        this.nume = a.nume;
        this.anul = a.anul;
        this.accidente = a.accidente;
        this.costulAccidente = a.costulAccidente;
        automobile++;


    }



    public  void printInfo(){

        System.out.println("Total automobile: " + automobile);
        System.out.println("Nume: " + nume);
        System.out.println("Anul producerii: " + anul);
        System.out.println("Accidente: " + accidente);

        if (costulAccidente != null)
        for(int i=0;i<costulAccidente.length;i++){
            System.out.println("  Accident nr"+(i+1)+" - "+costulAccidente[i]+"$");
        }
    }
    //functia care seteaza tot de la tastatura

    public void setInfoFromKeyboard(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nume: ");
        nume = sc.next();
        System.out.print("Anul: ");
        anul = sc.nextInt();
        System.out.print("Accidente: ");
        accidente = sc.nextInt();
        System.out.print("De cate ori a fost reparata masina? ");
        int nr = sc.nextInt();
        costulAccidente = new int[nr];
        System.out.println("Urmeaza sa introduceti costul fiecarei reparatii ");
        for(int i=0;i<costulAccidente.length;i++){
            costulAccidente[i] = sc.nextInt();
        }

    }


    public void compare(Automobil a){
        System.out.println(this.nume+(" --- ")+accidente+(" accidente") );
        System.out.println(a.nume+(" --- ")+a.accidente+(" accidente") );

    }

    public int sumaReparatie()
    {
        int sum = 0;
        if (costulAccidente!=null)
        {
            for (int i = 0; i < costulAccidente.length; i++) {
                sum += costulAccidente[i];
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
        anul = an;
    }

    public int getAn() {
        return anul;
    }



    public void setAccidente(int accidente) {
        this.accidente = accidente;
    }

    public int getAccidente() {
        return accidente;
    }

    public void setCostulAccidente(int costulAccidente[]) {
        this.costulAccidente = costulAccidente;
    }
    public int[] getCostulAccidente() {
        return costulAccidente;
    }
}


