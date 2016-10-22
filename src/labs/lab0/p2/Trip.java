package labs.lab0.p2;

abstract class Trip {
    protected String name;
    protected int price;

    Trip(String name, int price) {
        this.name = name;
        this.price = price;
    }

    Trip() {
        this("Unknown", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    abstract int vratiVremeVoDenovi();
    abstract int returnMonth();

    static int minPrice(Trip[] niza, int n, Trip holiday) {
        int i = 0;
        int min = -1;
        for (; i < n; ++i) {
            if (niza[i].vratiVremeVoDenovi() > holiday.vratiVremeVoDenovi()) {
                min = i;
                break;
            }
        }
        if (min != -1) {
            while (i < n) {
                if (niza[i].vratiVremeVoDenovi() < holiday.vratiVremeVoDenovi()) {
                    if (niza[i].getPrice() < niza[min].getPrice()) {
                        min = i;
                    }
                }
                ++i;
            }
            return niza[min].getPrice();
        }
        else {
            return min;
        }
    }
}

