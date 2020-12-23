package Printable;

public class PrintableLetter implements Printable {
    private final char c;
    private final int n;

    public PrintableLetter(char c, int n) {
        this.c = c;
        this.n = n;
    }

    @Override
    public void print() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) { s.append(c); }
        System.out.println(s);
    }
}
