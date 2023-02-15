package DZ_7.lesson7.hw;

public class Main {

    public static void main(String[] args) {
        // Есть машина, которая умеет делать круглые отверстия для круглых колышков (RoundPeg).
        // Также у нас есть квадратные колышки (SquareSide).
        // Задача: научить машину делать отверстия для квадратных колышков (реализовать паттерн адаптер).
        // Нужно "адаптировать" интерфейс SquarePeg под интерфейс RoundPeg

        RoundPegHoleMachine machine = new RoundPegHoleMachine();

        RoundPeg peg = new DefaultRoundPeg(2.0);
        SquarePeg sqPeg = new DefaultSquarePeg(5);
        RoundHole hole = machine.create(peg);
        System.out.println(hole.radius()); // 2.0

        RoundHoleAdapter roundHoleAdapter = new RoundHoleAdapter(sqPeg); // new ...
        System.out.println(roundHoleAdapter.squarePeg.side()); // 5.0
        RoundHole squareHole = machine.create(roundHoleAdapter);
        System.out.println(squareHole.radius()); // ~ 3.5355
        // side -> radius
    }
















}
