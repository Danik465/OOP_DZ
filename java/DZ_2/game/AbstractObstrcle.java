package DZ_2.game;

public abstract class AbstractObstrcle {
    private final int measure;

    protected AbstractObstrcle(int measure) {
        this.measure = measure;
    }

    public int getMeasure() {
        return measure;
    }
}
