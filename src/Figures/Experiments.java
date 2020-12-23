package Figures;

public class Experiments {
    public static void main(String[] args) {
        Circle a = new Circle(3);
        Square b = new Square(4);
        Rectangle c = new Rectangle(5, 6);
        Rhombus d = new Rhombus(10, 12);
        EquilateralTriangle e = new EquilateralTriangle(7);
        RectangularTriangle f = new RectangularTriangle(2, 8);

        Figure [] figures = {a, b, c, d, e, f};
        for (Figure i: figures) {
            System.out.println(i.info());
            System.out.println("Площадь: " + i.area());
            System.out.println("Периметр: " + i.perimeter());
            System.out.println("Ёмкость: " + i.capacity());
            System.out.println("Ёмкость 2: " +  Figure.capacity(i));
            System.out.println("------------------------------");
        }

    }
}
