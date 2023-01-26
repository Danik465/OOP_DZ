package DZ_2.game;

public class Game {

    /**
     * 0. Переварить весь код.
     * 1. В пакете org.example.lesson2.game проделать такую же процедуру, как и с WallAdapter, для остальных препятствий.
     * 2. Общие куски для препятствий вынести в какой-то базовый класс AbstractObstacle.
     * 3*. Придумать какой-то свой тип препятствия.
     * Проанализировать, что принципиально изменилось в структуре проекта при добавлении нового типа.
     *
     *
     * Ответ на 4-й вопрос:
     * При добавлении нового типа в программе ничего не именилось, только пришолсь в каждый конструктор участника
     * вносить изменения по новому препятствию. Также как то муторно, что для одного добавления препятствия нужно
     * создавать несколько новых интерфесов и классов. Думаю, можно как то от этого уйти. Получается мы увеличили гибкость
     * программы, но в тоже время усложнили её структуру.
     */
    public static void main(String[] args) {
        // Соревнования между участниками
        // Есть полоса препятствий, которая состоит из дорожки (с длиной) и стены (с высотой).
        // Участники преодолевают препятствия по очереди.

        Participant[] participants = createParticipants();
        Obstacle[] obstacles = createObstacles();

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                boolean overcome = obstacle.overcome(participant);
                if (overcome) {
                    System.out.println(participant.getName() +
                            " преодолел препятствие \"" + obstacle.type() + "\"");
                }
            }
        }

    }

    private static Participant[] createParticipants() {
        return new Participant[] {
                new Cat("Cat-1", 10, 2, 10),
                new Cat("Cat-2", 8, 5,10),
                new Human("Human-1", 8, 5, 3,30),
                new Cheater("Cheater")
        };
    }

    private static Obstacle[] createObstacles() {
        return new Obstacle[] {
                new RoadObstacleAdapter(new Road(9)),
                new SwimObstacleAdapter(new SwimmingPool(4)),
                new WallObstacleAdapter(new Wall(4)),
                new PushUpsObstacleAdapter(new PushUps(20))
        };
    }

}
