package DZ_1.example.example;

import java.util.List;

public interface RobotMap {
    public RobotMap.Robot createRobot(Point point) throws RobotCreationException;
    public List<RobotMap.Robot> getRobots();

    public interface Robot {
         void move() throws RobotMoveException;
         void move(int step)throws RobotMoveException;
         void changeDirection(Direction direction);
        DefualtRobotMap.MapPoint getPoint();
    }
}
