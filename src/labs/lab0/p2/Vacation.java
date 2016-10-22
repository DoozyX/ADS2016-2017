package labs.lab0.p2;

class Vacation extends Trip{
    private int duration;

    Vacation(String name, int price, int duration) {
        super(name, price);
        this.duration = duration;
        if(this.price <= 1000){
            this.price=0;
        }else{
            this.price -= 1000;
        }

    }

    public Vacation() {
        this("Unknown", 0, 0);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    int vratiVremeVoDenovi() {
        return this.duration;
    }

    @Override
    int returnMonth() {
        return 0;
    }
}
