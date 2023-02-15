package DZ_7.lesson7.hw;

public class RoundPegHoleMachine {

        public RoundHole create(RoundPeg peg) {

        return new DefaultRoundHole(peg.radius());

        }
    }