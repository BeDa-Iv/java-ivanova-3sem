package Figures;

public class Circle implements Figure {
    private final double r;

    public Circle (float r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI*r*r;
    }

    @Override
    public double perimeter() { return 2*Math.PI*r; }

    @Override
    public String info() { return "Круг с радиусом " + r; }

    @Override
    public double capacity() { return 1/(4*Math.PI); }

}
