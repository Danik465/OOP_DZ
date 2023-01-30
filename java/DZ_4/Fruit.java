package DZ_4;

public class Fruit {

    private double weight;
    private String name;

    public Fruit(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
