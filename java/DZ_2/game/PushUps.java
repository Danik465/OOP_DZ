package DZ_2.game;

public class PushUps extends AbstractObstrcle {



    public PushUps(int distance) {
        super(distance);
    }

    public boolean overcome(Pushable pushable) {
        int pushUpsLimit = pushable.getPushUpsLimit();
        return pushUpsLimit >= getMeasure();
    }

    public int getPushUpsLimit() {
        return getMeasure();
    }
}
