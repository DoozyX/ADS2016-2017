package exams.exam.exercise.p3;

import java.util.*;

class Rodendeni {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Set<Employee>> calendar = new HashMap<>();

		int n = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < n; i++) {
			String[] parts = scanner.nextLine().split("\\s+");
			String birthday[] = parts[2].split("/");
			String date = birthday[0] + "/" + birthday[1];
			Employee current = new Employee(parts[0], parts[1], date, Integer.parseInt(birthday[2]));
			Set<Employee> birthdays = calendar.computeIfAbsent(date, k -> new TreeSet<>(Comparator.comparing(Employee::getName)));
			birthdays.add(current);
		}

		String line[] = scanner.nextLine().split("/");

		String date = line[0] + "/" + line[1];
		int year = Integer.parseInt(line[2]);

		Set<Employee> print = calendar.get(date);

		if (print == null) {
			System.out.println("Nema");
		} else {
			for (Employee employee : print) {
				employee.print(year);
			}
		}

	}
}
