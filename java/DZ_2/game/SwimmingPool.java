package DZ_2.game;

public class SwimmingPool extends AbstractObstrcle{



    public SwimmingPool(int distance) {
        super(distance);
    }

    public boolean overcome(Swimmable swimmable) {
        int SwimLimit = swimmable.getSwimLimit();
        return SwimLimit >= getMeasure();
    }

    public int getDistance() {
        return getMeasure();
    }
}
