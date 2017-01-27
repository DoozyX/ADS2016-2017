package exams.exam.exercise.p1;

class Process {
	private String name;
	private int duration;
	private int arrival;

	public Process(String name, int duration, int arrival) {
		this.name = name;
		this.duration = duration;
		this.arrival = arrival;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public int getArrival() {
		return arrival;
	}

	@Override
	public String toString() {
		return "Process{" +
				"name='" + name + '\'' +
				", duration=" + duration +
				", arrival=" + arrival +
				'}';
	}
}
