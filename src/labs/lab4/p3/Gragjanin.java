package labs.lab4.p3;

class Gragjanin {
    private String imePrezime;
    private int lKarta, pasos, vozacka;

    Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
        super();
        this.imePrezime = imePrezime;
        this.lKarta = lKarta;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }

    public int getlKarta() {
        return lKarta;
    }

    public int getPasos() {
        return pasos;
    }

    public int getVozacka() {
        return vozacka;
    }

    public String getImePrezime() {
        return imePrezime;
    }
}