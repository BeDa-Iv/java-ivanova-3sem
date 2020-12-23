package Printable;

public class PrintableString implements Printable {

    private final String s;

    public PrintableString(String s) { this.s = s; }

    @Override
    public void print() { System.out.println(s); }

}