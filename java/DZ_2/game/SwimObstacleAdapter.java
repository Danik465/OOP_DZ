package DZ_2.game;

public class SwimObstacleAdapter implements Obstacle {

    private final SwimmingPool pool;

    public SwimObstacleAdapter(SwimmingPool pool) {
        this.pool = pool;
    }

    @Override
    public boolean overcome(Participant participant) {
        return pool.overcome(participant);
    }

    @Override
    public String type() {
        return "Бассейн";
    }
}
