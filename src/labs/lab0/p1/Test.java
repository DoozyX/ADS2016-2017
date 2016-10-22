package labs.lab0.p1;

import java.util.Scanner;

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
