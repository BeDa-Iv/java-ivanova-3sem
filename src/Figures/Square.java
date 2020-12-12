package Figures;

public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public double area() {
        return side*side;
    }

    @Override
    public String info() {
        return "Квадрат со стороной " + side;
    }

    @Override
    public double capacity() {
        return 1 / (double) 16;
    }

}