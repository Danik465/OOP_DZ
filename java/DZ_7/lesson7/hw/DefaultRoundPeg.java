package DZ_7.lesson7.hw;

public class DefaultRoundPeg implements RoundPeg {
    private final double radius;
    public DefaultRoundPeg(double radius) {
        this.radius = radius;
    }
    @Override
    public double radius() {
        return radius;
    }
}
