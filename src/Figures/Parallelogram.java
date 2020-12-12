package Figures;

public abstract class Parallelogram implements Figure{
    protected double side;
    protected double side2;

    public Parallelogram(double side, double side2) {
        this.side = side;
        this.side2 = side2;
    }

    public double perimeter() {
        return (side + side2) * 2;
    }

    public abstract double area();

}
