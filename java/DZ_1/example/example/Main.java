package DZ_1.example.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Есть двумерная карта с роботами
        // Роботы это объекты, они могут перемещаться по карте
        // Карта имеет какие-то границы
        // 2 робота не могут находиться в одной точке одновременно
        // Роботы имеют направление (которое можно менять (поворачивать)),
        //              роботы идут только вперед (или стоят на месте).

//        RobotMap.Robot robot = new RobotMap.Robot();
        //  0, 0                  0, n   -> <-
        //  1, 0                  1, n


        // m, 0                    m, n
        //

//        Scanner scanner = new Scanner(System.in);
//        RobotMap map = null;
//
//        System.out.println("Введите размер поля: (2 числа через пробел)");
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        try {
//            map = new RobotMap(n, m);
//        } catch (IllegalArgumentException e) {
//            System.err.println("Не удалось создать карту: " + e.getMessage());
//            System.out.println("Попробуйте еще раз");
//        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Здравствуйте, для начала давайте создадим карту!\nВведите параметры карты:");
        int n = sc.nextInt();
        int m = sc.nextInt();


        try{
            RobotMap map = new RobotMap(n, m);

            System.out.printf("Отлично! Вы создали карту %s на %s\nДальше нужно выбрать действие:", n,m);
            System.out.println("\n1. Создать робота на карте\n2. Выбрать существующего робота\n3. Выйти");
            int step = sc.nextInt();
            boolean flag = true;
            boolean flagbool = true;
            boolean orderflag = true;
            while (orderflag){
                switch (step) {
                    case 1 -> {
                        while (flag) {
                            System.out.println("Введите координаты робота:");
                            int x = sc.nextInt();
                            int y = sc.nextInt();

                            RobotMap.Robot robot1 = map.createRobot(new Point(x, y));
                            System.out.println("Робот создан\nЕсли нужно выйти обратно напишите 'Да' , " +
                                    "елси хотите продолжить напишите 'Нет'");
                            String flag1 = sc.next();
                            if (flag1.equals("Да")) {
                                flag = false;
                                System.out.println("1. Создать робота на карте\n2. Выбрать существующего робота\n3. Выйти");
                                step = sc.nextInt();
                            }

                        }

                    }
                    case 2 -> {
                        while (flagbool){
                            List<RobotMap.Robot> list = map.getRobots();
                            System.out.println(list);
                            System.out.println("Выберите номер робота по индексу");
                            int numb = sc.nextInt();
                            System.out.println("Выберите направление");
                            Direction direction = Direction.valueOf(sc.next());
                            RobotMap.Robot robot = list.get(numb);
                            robot.changeDirection(direction);
                            System.out.println("Выберите шаг перемещения");
                            int move = sc.nextInt();
                            robot.move(move);
                            System.out.println("Произведен шаг размером"+ move+" роботом "+ robot+"" +
                                    "\nТеперь он на позиции "+ robot.getPoint());
                            System.out.println("Робот перемещен\nЕсли нужно выйти обратно напишите 'Да' , " +
                                    "елси хотите продолжить напишите 'Нет'");
                            String flag2 = sc.next();
                            if (flag2.equals("Да")) {
                                flagbool = false;
                                System.out.println("1. Создать робота на карте\n" +
                                        "2. Выбрать существующего робота\n3. Выйти");
                                step = sc.nextInt();
                            }
                        }

                    }
                    case 3 -> {
                        orderflag = false;
                    }


                }


            }


        }catch (CreateMapValidationException | RobotCreationException | RobotMoveException e){
            System.err.println(e.getMessage());
        }

    }

    private void homework() {
        // 0. Добавить проверку входных данных в конструкторе RobotMap
        // 1. Доработать класс карты: запретить одновременное нахождение какого-то количества робов на карте.
        //    Ограничение в 10 роботов.
        // 2. Задать возможность вызова #move на заданное количество единиц.
        //    Метод без аргументов перемещает на 1 единицу.
        // 3*. Реализовать пользовательское взаимодействие с картой через консоль.
        // 3.1 Через консоль спрашивать параметры создания карты
        // 3.2 Через консоль спрашивать создания робота или его передвижение
        //     Например, move 17489123641-84-1o1-321 TOP 10
        // 3.3 Любые другие взаимодействия пользователя с картой...
        // 4*. Попробовать реализовать какую-то свою структуру (Автомобиль)
    }

}
