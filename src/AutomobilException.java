import java.util.InputMismatchException;

public class AutomobilException extends Exception{
    int an_exception = 2000;
    int nr_accidente_exception = 0;
    int pret_accident_exception = 500;
    int probeg_exception = 1000;

    Object exception;

    public AutomobilException(int a, int flag){
        if (flag == 0) an_exception = a;

        if (flag == 1) nr_accidente_exception = a;

        if (flag == 2) pret_accident_exception = a;

        if (flag == 3) probeg_exception = a;

    }

    public AutomobilException(Exception e){
        exception = e;
    }




    public void handle(){
        if (an_exception <= 1885 || an_exception > 2024) System.out.println("Please introduce a valid year!");
        if (nr_accidente_exception <0 || nr_accidente_exception > 50) System.out.println("Please introduce " +
                "a valid numbers of accidents");
        if (pret_accident_exception <=0) System.out.println("Please introduce " + "a valid price of accident");

        if (probeg_exception<0||probeg_exception>1_000_000) System.out.println("Masina nu poate avea asa kilometraj!");

        if (exception instanceof InputMismatchException){
            System.out.println("Please introduce an int number!");
        }
    }

}
