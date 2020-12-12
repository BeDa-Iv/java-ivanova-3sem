package Figures;

public class Experiments {
    public static void main(String[] args) {
        Circle a = new Circle(5);
        Square b = new Square(5);
        Rectangle c = new Rectangle(4, 6);
        Rhombus d = new Rhombus(16, 9);
        EquilateralTriangle e = new EquilateralTriangle(4);
        RectangularTriangle f = new RectangularTriangle(4, 5);

        Figure [] figures = {a, b, c, d, e, f};
        for (Figure i: figures) {
            System.out.println(i.info());
            System.out.println("Площадь: " + i.area());
            System.out.println("Периметр: " + i.perimeter());
            System.out.println("Ёмкость: " + i.capacity());
            System.out.println("------------------------------");
        }

    }
}
