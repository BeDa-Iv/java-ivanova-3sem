package Figures;

import static java.lang.Math.pow;

public interface Figure {

    double area();
    double perimeter();
    String info();

    static double capacity(Figure f) {
        return f.area()/pow(f.perimeter(),2);
    }

    default double capacity() {
        return area()/pow(perimeter(),2);
    }

}