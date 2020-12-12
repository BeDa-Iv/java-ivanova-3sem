package Figures;

import static java.lang.Math.pow;

public class RectangularTriangle implements Figure {
    private final double side1;
    private final double side2;

    public RectangularTriangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double area() {
        return side1*side2*0.5;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + Math.sqrt(pow(side1, 2)+pow(side2, 2));
    }

    @Override
    public String info() {
        return "Прямоугольный треугольник с катетами " + side1 + " и " + side2;
    }
}