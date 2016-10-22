package labs.lab0.p2;

class FestiveTrip extends Trip{
    private int startDay;
    private int startMonth;
    private int endDay;
    private int endMonth;

    public FestiveTrip(String name, int price, int startDay, int startMonth, int endDay, int endMonth) {
        super(name, price);
        try {
            if (startMonth > endMonth) {
                throw new Exception();
            } else if (startMonth == endMonth) {
                if (startDay > endDay) {
                    throw new Exception();
                }
            }
        }catch (Exception e) {
            int temp;
            temp = startDay;
            startDay = endDay;
            endDay = temp;

            temp = startMonth;
            startMonth = endMonth;
            endMonth = temp;

            System.out.println("Exception");
        }
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.endDay = endDay;
        this.endMonth = endMonth;
    }

    public FestiveTrip() {
        this("Unknown", 0,0,0,0,0);
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    @Override
    int vratiVremeVoDenovi() {
        int days = 0;
        int monthDif = endMonth - startMonth;
        if(monthDif > 1) {
            days = 30 * monthDif;
            days += (30-startDay) + endDay;
        }else if (monthDif == 1) {
            days += (30-startDay) + endDay;
        }
        else {
            days = endDay - startDay;
        }
        return days;
    }

    @Override
    int returnMonth() {
        return getStartMonth();
    }
}
