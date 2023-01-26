package DZ_2.game;

public abstract class Participant implements Runnable, Jumpable, Swimmable, Pushable {

    private final String name;
    private final int distanceLimit;
    private final int swimLimit;
    private final int jumpLimit;
    private final int countPushUpsLimit;

    protected Participant(String name, int distanceLimit, int swimLimit, int jumpLimit, int countPushUpsLimit) {
        this.name = name;
        this.distanceLimit = distanceLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
        this.countPushUpsLimit = countPushUpsLimit;
    }


    public String getName() {
        return name;
    }

    @Override
    public int getDistanceLimit() {
        return distanceLimit;
    }

    @Override
    public int getSwimLimit() {
        return swimLimit;
    }

    @Override
    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public int getPushUpsLimit() {
        return countPushUpsLimit;
    }
}
