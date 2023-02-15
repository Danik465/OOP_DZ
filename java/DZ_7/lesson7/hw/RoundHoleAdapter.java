package DZ_7.lesson7.hw;

public class RoundHoleAdapter implements RoundPeg {
    final SquarePeg squarePeg;


    RoundHoleAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double radius() {
        double side = squarePeg.side();
        return Math.sqrt(Math.pow(side,2)+ Math.pow(side,2))/2;
    }
}