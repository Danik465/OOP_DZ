package DZ_1.example.example;

public class RobotMoveException extends Exception {

    private final DefualtRobotMap.RobotDefault robotDefault;

    public RobotMoveException(String message, DefualtRobotMap.RobotDefault robotDefault) {
        super(message);
        this.robotDefault = robotDefault;
    }

    public DefualtRobotMap.RobotDefault getRobot() {
        return robotDefault;
    }
}
