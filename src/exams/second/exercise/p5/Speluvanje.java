package exams.second.exercise.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**

 Opened: 00:00:15
 Проверка на спелување Problem 5 (0 / 0)
 Потребно е да се направи проверка на текст даден на англиски, дали е во ред напишан (односно дали правилно се напишани зборовите). За таа цел прво се даваат речник на зборови (односно листа на зборови кои ги содржи англискиот јазик), а потоа се дава текст. Како резултат треба да се испечатат сите зборови кои се направилно напишани или ги нема во речникот.

 Влез: Прво се дава број N на поими кои ќе ги содржи речникот, а во наредните N реда се дадени зборовите кои ги содржи англискиот јазик. Потоа се дава еден текст, кој треба да се провери дали е правилно напишан.

 Излез: Се печати листа на зборови кои се неправилно напишани (секој во посебен ред). Доколку сите зборови се добро напишани се печати: Bravo.

 Забелешка: Треба да се игнорираат интерпункциск знаци како точка (.), запирка (,), извичник (!) и прашалник (?). Исто така да се внимава на голема и мала буква, односно иако зборовите во речникот се со мали букви, во реченица може да појават со голема почетна буква и притоа се сметаат за точни. Работете со хеш табела со отворени кофички. Сами треба да го одредите бројот на кофички и хеш функцијата.

 Sample input
 4
 where
 is
 my
 cat
 Where is my cat?

 Sample output
 Bravo
 */

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {
	K key;
	E value;

	public MapEntry (K key, E val) {
		this.key = key;
		this.value = val;
	}
	public int compareTo (K that) {
		@SuppressWarnings("unchecked")
		MapEntry<K,E> other = (MapEntry<K,E>) that;
		return this.key.compareTo(other.key);
	}
	public String toString () {
		return "(" + key + "," + value + ")";
	}
}


class OBHT<K extends Comparable<K>,E> {

	private MapEntry<K,E>[] buckets;
	static final int NONE = -1; // ... distinct from any bucket index.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static final MapEntry former = new MapEntry(null, null);
	private int occupancy = 0;

	@SuppressWarnings("unchecked")
	public OBHT (int m) {
		buckets = (MapEntry<K,E>[]) new MapEntry[m];
	}

	private int hash (K key) {
		return Math.abs(key.hashCode()) % buckets.length;
	}

	public MapEntry<K,E> getBucket(int i){
		return buckets[i];
	}

	public int search (K targetKey) {
		int b = hash(targetKey); int n_search=0;
		for (;;) {
			MapEntry<K,E> oldEntry = buckets[b];
			if (oldEntry == null)
				return NONE;
			else if (targetKey.equals(oldEntry.key))
				return b;
			else{
				b = (b + 1) % buckets.length;
				n_search++;
				if(n_search==buckets.length)
					return NONE;
			}
		}
	}

	public void insert (K key, E val) {
		MapEntry<K,E> newEntry = new MapEntry<K,E>(key, val);
		int b = hash(key); int n_search=0;

		for (;;) {
			MapEntry<K,E> oldEntry = buckets[b];
			if (oldEntry == null) {
				if (++occupancy == buckets.length) {
					System.out.println("Hash tabelata e polna!!!");
				}
				buckets[b] = newEntry;
				return;
			} else if (oldEntry == former
					|| key.equals(oldEntry.key)) {
				buckets[b] = newEntry;
				return;
			} else{
				b = (b + 1) % buckets.length;
				n_search++;
				if(n_search==buckets.length)
					return;

			}
		}
	}

	@SuppressWarnings("unchecked")
	public void delete (K key) {
		int b = hash(key); int n_search=0;
		for (;;) {
			MapEntry<K,E> oldEntry = buckets[b];

			if (oldEntry == null)
				return;
			else if (key.equals(oldEntry.key)) {
				buckets[b] = former;
				return;
			} else{
				b = (b + 1) % buckets.length;
				n_search++;
				if(n_search==buckets.length)
					return;

			}
		}
	}

	public String toString () {
		String temp = "";
		for (int i = 0; i < buckets.length; i++) {
			temp += i + ":";
			if (buckets[i] == null)
				temp += "\n";
			else if (buckets[i] == former)
				temp += "former\n";
			else
				temp += buckets[i] + "\n";
		}
		return temp;
	}
}


class Zbor implements Comparable<Zbor>{
	String zbor;

	public Zbor(String zbor) {
		this.zbor = zbor;
	}
	@Override
	public boolean equals(Object obj) {
		Zbor pom = (Zbor) obj;
		return this.zbor.equals(pom.zbor);
	}
	@Override
	public int hashCode() {
		/*
		*
		* Vie ja kreirate hesh funkcijata
		*
		*/
		return -1;
	}
	@Override
	public String toString() {
		return zbor;
	}
	@Override
	public int compareTo(Zbor arg0) {
		return zbor.compareTo(arg0.zbor);
	}
}

public class Speluvanje {
	public static void main(String[] args) throws IOException {
		OBHT<Zbor, String> tabela;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//---Vie odluchete za goleminata na hesh tabelata----
		tabela = new OBHT<Zbor,String>(0);

		/*
		*
		* Vashiot kod tuka....
		*
		*/
		//check 169
	}
}
