package DZ_2.game;

public class Cat extends Participant {


    protected Cat(String name, int distanceLimit, int jumpLimit, int countPushUpsLimit) {
        super(name, distanceLimit, -1, jumpLimit, countPushUpsLimit);
    }
}