package labs.lab0.p1;

class Athlete {
    private String name;
    private String gender;
    private int age;
    private double timeScore;
    private String country;

    Athlete(String name, String gender, int age, double timeScore, String country) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.timeScore = timeScore;
        this.country = country;
    }

    Athlete() {
        this("Unknown", "Unknown", 0, 0, "Unknown");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTimeScore() {
        return timeScore;
    }

    public void setTimeScore(double timeScore) {
        this.timeScore = timeScore;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name + '\n' +
                age + '\n' +
                country + '\n' +
                timeScore + '\n';
    }
}
