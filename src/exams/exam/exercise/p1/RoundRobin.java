package exams.exam.exercise.p1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class RoundRobin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		scanner.nextLine();

		LinkedList<Process> tasks = new LinkedList<>();


		for (int i = 0; i < n; i++) {
			String[] parts = scanner.nextLine().split("\\s+");
			String name = parts[0];
			int duration = Integer.parseInt(parts[1]);
			int arrival = Integer.parseInt(parts[2]);
			tasks.addLast(new Process(name, duration, arrival));
		}
		int timePerProcess = scanner.nextInt();

		tasks.sort(Comparator.comparing(Process::getArrival).thenComparing(Comparator.comparing(Process::getDuration).reversed()));

		while (!tasks.isEmpty()) {
			Process current = tasks.getFirst();
			System.out.print(current.getName() + " ");

			int durationLeft = current.getDuration()-timePerProcess;
			if (durationLeft > 0) {
				current.setDuration(durationLeft);
				tasks.addLast(current);
			}
			tasks.removeFirst();

		}
	}
}
