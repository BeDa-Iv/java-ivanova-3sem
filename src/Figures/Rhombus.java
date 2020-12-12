package Figures;

import static java.lang.Math.pow;

public class Rhombus extends Parallelogram {
    private final double d1;
    private final double d2;

    public Rhombus(float d1, float d2) {
        super(Math.sqrt(pow(d1/2, 2)+pow(d2/2, 2)), Math.sqrt(pow(d1/2, 2)+pow(d2/2, 2)));
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public double area() {
        return d1*d2*0.5;
    }

    @Override
    public String info() { return "Ромб с диагоналями " + d1 + " и " + d2; }
}
