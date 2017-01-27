package labs.lab6.p3;

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
        return zbor.hashCode();
    }
    @Override
    public int compareTo(Zbor arg0) {
        return zbor.compareTo(arg0.zbor);
    }
}