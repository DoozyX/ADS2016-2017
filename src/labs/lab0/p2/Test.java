package labs.lab0.p2;

import java.util.Scanner;
/*
        Trip Problem 2
        Define Java class Trip. The attributes for this class are: name of the agency that organize the trip (String) and price of the arrangement (int).

        For this class implement:

        appropriate constructor set and get methods

        A duration of each trip can be calculated by the method: int vratiVremeVoDenovi();.

        A trip can be either a festive trip or a vacation. Model classes FestiveTrip and Vacation. Moreover, besides the name and price for every vacation,
        store data for the duration of the trip in days (int), while for every festive trip store data for start day (int) and month (int) and end day (int) and month (int) of the trip.
        On the bases of these data the number of days (taken that all months have 30 days) can be determined.

        For the classes FestiveTrip and Vacation implement:

        appropriate constructors set and get methods appropriate methods

        In addition, take into account the real price for the vacation is 1,000 denars cheaper. These (1,000 denars) are paid by the state.

        Exceptions: Festive trips are conducted in the same year, and the start day should precede the calendar end day of the trip.
        If you attempt to instantiate an object of the FestiveTrip class where it is not fulfilled, it is necessary to throw a general exception Exception.
        It should be caught in the constructor where it is thrown. Deal with it so that you will replace the values for the start day and month with the end day and month of the trip.
        Thus if the exception is caught to be printed in a new line message on the screen: Exeption.

        In the main method of the Test class created is an array of n variables of type Trip. Since from the standard input is entered information on the elements of the array,
        task is to implement the following requirements:

        (Requirement 1 ) On a standard output print the names of all the agencies that offer festive trips that start in June, (in a row and separated by a space).
        (Requirement 2 ) On a standard output print the average duration of all trips expressed in days.
        (Requirement 3 ) From a standard input read information about a vacation (name, price, duration).
        Create a variable holiday of type Vacation which referenced to an object of type (Vacation) created with information from the input.
        (Requirement 4 ) On a standard output print minimum price of the trip from those trips which duration is longer than vacation that is loaded from the input (holiday).
        While for it, use the method int minPrice(Trip[] niza, int n, Trip holiday);This method is a static into the Trip class.
*/

public class Test {
    public static void main(String[] args) {


        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();

        Trip nizaPatuvanje[]=new Trip[n];

        for (int i=0;i<n;i++){
            int tip=in.nextInt();
            if (tip==0){
                String ime=in.next();
                int cena =in.nextInt();
                int vreme=in.nextInt();
                nizaPatuvanje[i]=new Vacation(ime,cena,vreme);
            }
            else {
                String ime=in.next();
                int cena =in.nextInt();
                int pocD=in.nextInt();
                int pocM=in.nextInt();
                int krajD=in.nextInt()  ;
                int krajM=in.nextInt();
                nizaPatuvanje[i]=new FestiveTrip(ime,cena,pocD,pocM, krajD,krajM);

            }
        }

        //решение на барање 1
        for (int i = 0; i < n - 1; ++i) {
            if(nizaPatuvanje[i].returnMonth() == 6){
                System.out.print(nizaPatuvanje[i].getName() + " ");
            }
        }
        System.out.println("");


        //решение на барање 2
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            sum += nizaPatuvanje[i].vratiVremeVoDenovi();
            System.out.println(nizaPatuvanje[i].vratiVremeVoDenovi());
            ++count;
        }
        System.out.println((double) sum / count);

        //решение на барање 3
        String ime = in.next();
        int cena =in.nextInt();
        int vreme = in.nextInt();
        in.close();
        Vacation holiday = new Vacation(ime, cena, vreme);

        //решение на барање 4
        System.out.println(Trip.minPrice(nizaPatuvanje, n, holiday));
    }

}
