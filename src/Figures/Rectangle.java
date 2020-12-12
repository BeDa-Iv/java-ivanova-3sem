package Figures;

public class Rectangle extends Parallelogram {
    public Rectangle(double height, double width) {
        super(height, width);
    }

    @Override
    public double area() { return side*side2; }

    @Override
    public String info() { return "Прямоугольник с высотой " + side + " и шириной " + side2; }
}
