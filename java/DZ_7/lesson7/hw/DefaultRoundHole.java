package DZ_7.lesson7.hw;

public class DefaultRoundHole implements RoundHole {
    private final double radius;
    public DefaultRoundHole(double radius) {
        this.radius = radius;
    }
    public double radius() {
        return radius;
    }
}
