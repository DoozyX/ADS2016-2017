package exams.second.exercise.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Кумановски дијалект Problem 1
 Даден ви е речник на зборови на кумановски дијалект и како тие се пишуваат на македонски јазик.
 Потоа даден ви е текст којшто е напишан на кумановски дијалект. Потребно е да ги замените сите појавувања на зборовите на кумановскиот дијалект кои се дадени во речникот со соодветни зборови на македонски јазик.

 Забелешка: Треба да се игнорираат интерпункциските знаци точка (.) , запирка (,), извичник(!) и прашалник (?).
 Исто така зборовите во текстот можат да се појават и со прва голема буква и во тој случај неговиот синоним на македонски јазик исто така треба да се отпечати со прва голема буква.

 Sample input
 20
 nego otkolku
 pesmu pesna
 bija bil
 u vo
 s’s so
 zhenu zhena
 ubavu ubava
 sakaja sakal
 ednu edna
 poznatu poznata
 pesmu pesna
 umreja umrel
 sliku slika
 zelje zelbi
 rakiju rakija
 ede jade
 skup skap
 chasku chaska
 povishke povekje
 narodnu narodna
 Batko Gjorgjija e tipichna figura i karakter od Kumanovo, koj bija golem majtapdzija i boem i koj povishke sakaja kjef da tera nego da raboti. U ednu poznatu narodnu pesmu vika se deka umreja s’s tri zelje za ubavu zhenu, za chasku rakiju i za skup pajton.

 Sample output
 Batko Gjorgjija e tipichna figura i karakter od Kumanovo, koj bil golem majtapdzija i boem i koj povekje sakal kjef da tera otkolku da raboti.
 Vo edna poznata narodna pesna vika se deka umrel so tri zelbi za ubava zhena, za chaska rakija i za skap pajton.
 */

public class KumanovskiDijalekt {
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

	public static String capitalLetter(String word, CBHT<String,String> cbht) {
		if (Character.isUpperCase(word.charAt(0))) {
			SLLNode <MapEntry <String,String>> sllNode = cbht.search(word.toLowerCase());
			if (sllNode == null) {
				return word;
			} else {
				String lower = sllNode.element.value;
				return lower.substring(0, 1).toUpperCase() + lower.substring(1);
			}
		} else {
			SLLNode <MapEntry <String,String>> node = cbht.search(word);
			if (node == null) {
				return word;
			} else {
				return node.element.value;
			}
		}
	}
	public static void main (String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		int N = Integer.parseInt(br.readLine());

		String rechnik[]=new String[N];
		for(int i=0;i<N;i++){
			rechnik[i]=br.readLine();
		}

		String tekst=br.readLine();
		//Vasiot kod tuka
		CBHT<String,String> cbht = new CBHT<>(next_prime(next_prime((int)Math.floor(1.75*N))));
		for (String string : rechnik) {
			String[] words = string.split("\\s+");
			cbht.insert(words[0],words[1]);
		}

		String[] words = tekst.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			char lastLetter = word.charAt(word.length()-1);
			if (!Character.isAlphabetic(lastLetter)){
				String without = word.substring(0,word.length()-1);
				SLLNode <MapEntry <String,String>> sllNode = cbht.search(without.toLowerCase());
				without = capitalLetter(without,cbht);
				sb.append(without).append(lastLetter).append(" ");
			}else {
				sb.append(capitalLetter(word,cbht)).append(" ");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}