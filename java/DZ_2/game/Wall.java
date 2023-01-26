package DZ_2.game;

public class Wall extends AbstractObstrcle{



    public Wall(int distance) {
        super(distance);
    }

    public boolean overcome(Jumpable jumpable) {
        int jumpLimit = jumpable.getJumpLimit();
        return jumpLimit >= getMeasure();
    }

    public int getHeight() {
        return getMeasure();
    }
}
