package exams.exam.exercise.p3;

class Employee {
	private String name;
	private String surname;
	private String date;
	private int year;

	public Employee(String name, String surname, String date, int year) {
		this.name = name;
		this.surname = surname;
		this.date = date;
		this.year = year;
	}

	public String getName() {
		return name;
	}


	public void print(int year) {
		System.out.println(name + " " + surname + " " + (year-this.year));
	}
}
