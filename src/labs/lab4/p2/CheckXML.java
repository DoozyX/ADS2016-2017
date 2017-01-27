package labs.lab4.p2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import labs.lab4.p1.ArrayStack;

/**
 Modified XML code Problem 2 (0 / 0)
 It is given a modified XML code. The modified XML code uses the symbols "["and"]" which are the opening and closing tag, respectively, instead of the standard symbols "<" and ">". Check if all the tags in the code are properly nested (code is valid), i.e. does every opening tag have suitable closing tag with the same name at the appropriate place in the code. For simplification, it is given that every opening tag must have a closing tag and tags do not have attributes.

 The number of code lines is given in the first input line. Then each XML tag is written in a new line. The output should print 1 for valid or 0 for invalid code.

 Explanation: In the modified XML code, every opening tag is structured as [nameOfTag], and every closing tag as [/ nameOfTag].

 Example for correct nested tags in XML:
 [tag1]
 [tag2]
 data
 [/tag2]
 [/tag1]
 Example for incorrect nested tags in XML:
 [tag1]
 [tag2]
 Podatok
 [/tag1]
 [/tag2]

 Sample input
 20
 [Korisnik]
 [Ime]
 Jana
 [/Ime]
 [Prezime]
 [Korisnik]
 [Ime]
 Ivan
 [/Ime]
 [Prezime]
 [/Prezime]
 [MBR]
 2807986455092
 [/MBR]
 [/Korisnik]
 [/Prezime]
 [MBR]
 2908986455091
 [/MBR]
 [/Korisnik]

 Sample output
 1
 */

public class CheckXML {
    static boolean checkTags(String a, String b) {
        if(a.length() == (b.length() - 1)) {
            b = b.replace("/", "");
            return a.equals(b);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid;
        ArrayStack<String> tagStack = new ArrayStack<>(1000);

        // Your code here
        // You can use additional functions
        valid = 1;
        for (int i = 0; i < n; i++) {
            if(redovi[i].charAt(0) == '[' && redovi[i].charAt(1) == '/' && redovi[i].charAt(redovi[i].length() - 1) == ']') {
                if(!tagStack.isEmpty()) {
                    String temp = tagStack.pop();
                    if (!checkTags(temp,redovi[i])) {
                        valid = 0;
                        break;
                    }
                } else {
                    valid = 0;
                    break;
                }
            } else if(redovi[i].charAt(0) == '[' && redovi[i].charAt(redovi[i].length() - 1) == ']') {
                tagStack.push(redovi[i]);
            }
        }
        System.out.println(valid);

        br.close();
    }
}