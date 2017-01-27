package labs.lab0.p1;

import java.util.Scanner;

/**
 Marathon Problem 1
 Define Java interface IMarathon with the following methods:

 Athlete bestTime() - that returns the winner of the marathon

 int AthletesFrom(String s) - that returns the number of athletes from s country.

 Define Java class Athlete. For every athlete the following information is stored: name (String), gender (String), age (int), time score in seconds (double) and country of origin (String). For this class implement:

 constructors (default and with parameters)
 set and get methods
 the method toString() in the following format: name / age / country of origin / time score (all of the parameters should be split with one space)
 Define Java class Marathon that implements the interface IMarathon. For every marathon the following information is stored: host country (String), year (int), an array of Athletes Athlete[]. For this class implement:

 constructors (default and with parameters)
 set and get methods
 the method toString() in the following format: host country / year / attendees of the marathon (all of the parameters should be split with one space)
 bestTime()
 AthletesFrom(String s)
 */

public class Test {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Athlete[] atleticari = new Athlete[n];

        String ime;
        String pol;
        int vozrast;
        double vreme;
        String zemja;

        input.nextLine();

        for(int i=0;i<n;i++)
        {
            ime = input.nextLine();
            pol = input.nextLine();
            vozrast = input.nextInt();
            vreme = input.nextDouble();
            input.nextLine();
            zemja = input.nextLine();
            atleticari[i]=new Athlete(ime,pol,vozrast,vreme,zemja);
        }

        String mesto;
        int godina;
        String zemjaP;
        mesto = input.nextLine();
        godina = input.nextInt();
        input.nextLine();

        Marathon m1 = new Marathon(mesto, godina, atleticari);
        System.out.print(m1.toString());

        zemjaP = input.nextLine();
        System.out.println("Prvo mesto: " + m1.bestTime().toString());
        System.out.println("Ima vkupno " + m1.AthletesFrom(zemjaP) + " atleticar/i od " + zemjaP);
    }
}
