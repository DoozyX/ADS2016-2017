package labs.lab0.p2;

import java.util.Scanner;

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
