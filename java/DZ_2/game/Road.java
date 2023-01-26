package DZ_2.game;

public class Road extends AbstractObstrcle {



    public Road(int distance) {
        super(distance);
    }

    public boolean overcome(Runnable runnable) {
        int distanceLimit = runnable.getDistanceLimit();
        return distanceLimit >= getMeasure();
    }

    public int getDistance() {
        return getMeasure();
    }
}
