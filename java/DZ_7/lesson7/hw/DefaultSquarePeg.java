package DZ_7.lesson7.hw;

public class DefaultSquarePeg implements SquarePeg {
    private final double side;
    public DefaultSquarePeg(double side) {
        this.side = side;
    }
    @Override
    public double side() {
        return side;
    }
}