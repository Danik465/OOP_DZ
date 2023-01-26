package DZ_2.game;

public class PushUpsObstacleAdapter implements Obstacle {

    private final PushUps push;

    public PushUpsObstacleAdapter(PushUps push) {
        this.push = push;
    }

    @Override
    public boolean overcome(Participant participant) {
        return push.overcome(participant);
    }

    @Override
    public String type() {
        return "Отжимания";
    }
}
