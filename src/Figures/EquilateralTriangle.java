package Figures;

class EquilateralTriangle implements Figure {
    private final double side;

    public EquilateralTriangle(float side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side*Math.sqrt(3)*0.25;
    }

    @Override
    public double perimeter() {
        return side*3;
    }

    @Override
    public String info() {
        return "Равноcторонний треугольник со стороной " + side;
    }
}
