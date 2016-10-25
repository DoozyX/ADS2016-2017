package labs.lab0.p1;

import java.util.Arrays;

/*      Marathon Problem 1
        Define Java interface IMarathon with the following methods:

        Athlete bestTime() - that returns the winner of the marathon

        int AthletesFrom(String s) - that returns the number of athletes from s country.

        Define Java class Athlete. For every athlete the following information is stored: name (String), gender (String), age (int), time score in seconds (double) and country of origin (String). For this class implement:

        constructors (default and with parameters)
        set and get methods
        the method toString() in the following format: name / age / country of origin / time score (all of the parameters should be split with one space)
        Define Java class Marathon that implements the interface IMarathon. For every marathon the following information is stored: host country (String), year (int), an array of Athletes Athlete[]. For this class implement:

        constructors (default and with parameters)
        set and get methods
        the method toString() in the following format: host country / year / attendees of the marathon (all of the parameters should be split with one space)
        bestTime()
        AthletesFrom(String s)
*/

class Marathon implements IMarathon {
    private String country;
    private int year;
    private Athlete[] athletes;

    Marathon(String country, int year, Athlete[] athletes) {
        this.country = country;
        this.year = year;
        this.athletes = new Athlete[athletes.length];
        this.athletes = Arrays.copyOf(athletes, athletes.length);
    }

    public Marathon() {
        this("Unknown", 0, null);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Athlete[] getAthletes() {
        return athletes;
    }

    public void setAthletes(Athlete[] athletes) {
        this.athletes = athletes;
    }

    @Override
    public Athlete bestTime() {
        Athlete best = athletes[0];
        for (int i = 1; i < athletes.length; ++i) {
            if(athletes[i].getTimeScore() < best.getTimeScore()) {
                best = athletes[i];
            }
        }
        return best;
    }

    @Override
    public int AthletesFrom(String s) {
        int count = 0;
        for (Athlete athlete : athletes) {
            if(athlete.getCountry().equals(s)) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        String athletesPrint = "";
        for (Athlete athlete : athletes) {
            athletesPrint += athlete.toString();
        }
        return country + '\n' +
                year + '\n' +
                athletesPrint;
    }
}
