package labs.lab4.p3;

import java.util.Scanner;

/**
 Counter of the Ministry of Internal Affairs Problem 3
 Every morning people come to the Ministry of Internal Affairs to apply for one or more documents.
 The document can be one of the following:
 1. ID card
 2. Passport
 3. Driving license
 People waiting for ID card are served first when the counter opens, then those for passport and finally those waiting for driving license. Every person waits in the queue for the appropriate document that he/she applies for (i.e. either in the queue for ID cards or in the queue for passports in the queue or for driving licenses). If a person has to apply for more documents, first he/she applies for ID card, then for passport and finally for driving license. So if a person applies for ID card and driving license he/she first waits in the queue for ID cards and when he/she finishes, he/she goes at the end of queue for driving licenses.

 The first input line indicates how many people came to MIA. Then, four lines are entered for every person (first name and surname are entered in the first line, and the three other lines are for the specifying the appropriate document (identity card, passport and driving license) that a person applies for. 1 means that the person applies for the document and 0 means that he/she does not apply.

 For example:

 Aleksandar Aleksandrovski
 1
 0
 1
 means that Alexander Aleksandrovski will apply for ID card and driving license, but not for passport.
 Output should print the names of people in order they finish with applying.

 Sample input
 4
 Aleksandar Aleksandrovski
 0
 0
 1
 Petre Petreski
 1
 0
 0
 Branka Brankovska
 0
 0
 1
 Jana Janevska
 0
 1
 0

 Sample output
 Petre Petreski
 Jana Janevska
 Aleksandar Aleksandrovski
 Branka Brankovska
 */

public class MVR {
    public static void otvoriShalter(ArrayQueue<Gragjanin> redicaLkarti,
                                     ArrayQueue<Gragjanin> redicaPasos, ArrayQueue<Gragjanin> redicaVozacka){
        // Your code here
        int n = redicaLkarti.size();
        for (int i = 0; i < n; i++) {
            Gragjanin temp;
            temp = redicaLkarti.dequeue();
            if(temp.getPasos() == 0 && temp.getVozacka() == 0) {
                System.out.println(temp.getImePrezime());
            } else if (temp.getPasos() == 1) {
                redicaPasos.enqueue(temp);
            } else if (temp.getVozacka() == 1) {
                redicaVozacka.enqueue(temp);
            }
        }
        n = redicaPasos.size();
        for (int i = 0; i < n; i++) {
            Gragjanin temp;
            temp = redicaPasos.dequeue();
            if(temp.getVozacka() == 0) {
                System.out.println(temp.getImePrezime());
            } else {
                redicaVozacka.enqueue(temp);
            }
        }
        n = redicaVozacka.size();
        for (int i = 0; i < n; i++) {
            Gragjanin temp;
            temp = redicaVozacka.dequeue();
            System.out.println(temp.getImePrezime());
        }
    }

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        ArrayQueue<Gragjanin> redicaLkarti = new ArrayQueue<>(10);
        ArrayQueue<Gragjanin> redicaPasos = new ArrayQueue<>(10);
        ArrayQueue<Gragjanin> redicaVozacka = new ArrayQueue<>(10);

        int N = Integer.parseInt(br.nextLine());
        for(int i=1;i<=N;i++){
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime,lKarta,pasos,vozacka);
            if(lKarta==1){
                redicaLkarti.enqueue(covek);
            }
            else if(pasos==1)
                redicaPasos.enqueue(covek);
            else
                redicaVozacka.enqueue(covek);
        }
        otvoriShalter(redicaLkarti, redicaPasos, redicaVozacka);
    }
}
