package labs.lab6.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Passwords Problem 1
 You are supposed to simulate a log in system. The user enters username and password.
 If such user exists in the system you are supposed to print "Najaven" to the standard output, else print "Nenajaven" and give the user another prompt for credentials.
 This stops when the user will enter username and password that match, a certain user credentials in the system.

 Input: In the first line of the input you are given a single integer N. In the following N lines you are given usernames and passwords separated with one white space.
 These are the users that exist in the system. After this you are supposed to read usernames and passwords from the standard input until, a user can be successfully logged in.

 Output: Print "Nenajaven" to the standard output for every failed log in try, until we get a successful log in. Then you have to print "Najaven"

 Example. Input: 3 ana banana pero zdero trpe trpi ana ana ana banana trpe trpi KRAJ

 Output: Nenajaven Najaven

 Note: Use closed bucket hash table. Figure out the hash table size by yourself. The hash function has already been given to you.

 Class name: Lozinki

 Sample input
 3
 ana banana
 pero zdero
 trpe trpi
 ana ana
 ana bannana
 trpe trpe
 KRAJ

 Sample output
 Nenajaven
 Nenajaven
 Nenajaven
 */

public class Lozinki {
    static boolean is_prime(int x) {
        for (int i = 3; true; i += 2) {
            int q = x / i;
            if (q < i)
                return true;
            if (x == q * i)
                return false;
        }
    }

    static int next_prime(int x) {
        if (x <= 2)
            return 2;
        if ((1 & x) == 0)
            ++x;
        for (; !is_prime(x); x += 2)
            ;
        return x;
    }
    public static void main (String[] args) throws IOException {
        CBHT<String,String> tabela;
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        int N = Integer.parseInt(br.readLine());
        //---Vie odluchete za goleminata na hesh tabelata----
        tabela = new CBHT<>(next_prime((int)Math.floor(1.75*N)));
        for(int i=1;i<=N;i++){
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            tabela.insert(pom[0], pom[1]);
        }
		/*
		*
		* Vashiot kod tuka....
		*
		*/
		String imelozinka;
        while (!(imelozinka = br.readLine()).equals("KRAJ")) {
            String[] pom = imelozinka.split(" ");
            SLLNode<MapEntry<String,String>> temp = tabela.search(pom[0]);
            if(temp == null) {
                System.out.println("Nenajaven");
            }else {
                if (pom[1].equals(temp.element.value)) {
                    System.out.println("Najaven");
                    break;
                }
                System.out.println("Nenajaven");
            }
        }
    }
}