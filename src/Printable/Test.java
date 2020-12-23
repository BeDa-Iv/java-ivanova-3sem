package Printable;

public class Test {
    public static void main(String[] args) {
        Drawing d = new Drawing(8, 8, '*');
        d.print();
        d.drawRectangle(1, 4, 5, 6, '#');
        d.print();

        PrintableLetter pl = new PrintableLetter('x', 15);
        pl.print(); //печатает букву x 10 раз

        PrintableString ps = new PrintableString("asdf");
        ps.print(); //печатает asdf

        Printable an = new Printable() {
            @Override
            public void print() {
                System.out.println("Анонимный класс");
            }
        };

        Printable la = ()->System.out.println("Лямбда выражение");

        Printable[] printables = {d, pl, ps, an, la};
        for (Printable element: printables) element.print();
    }
}