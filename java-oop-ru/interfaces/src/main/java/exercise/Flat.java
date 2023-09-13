package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area + balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (area == another.getArea()) {
            return 0;
        }
        return area > another.getArea() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + area + " метров на " + floor +  " этаже";
    }
}
// END
