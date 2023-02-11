package DZ_1.example.example;

import java.util.ArrayList;
import java.util.List;

public class DefualtRobotMap implements  RobotMap {

    private final int n;
    private final int m;
    private final List<Robot> robotDefaults;
    private  final int maxRobotCount;

    public List<Robot> getRobots() {
        return robotDefaults;
    }

    public DefualtRobotMap(int n, int m) throws CreateMapValidationException {
        this(n,m,10);

    }
    public DefualtRobotMap(int n, int m, int maxRobotCount) throws CreateMapValidationException {
        // TODO: 13.01.2023 Реализовать проверку входных параметров.

        if(n<0 || m<0){
            throw new CreateMapValidationException("Не корректно заданы координаты карты!");
        }else{
            this.n = n;
            this.m = m;
            this.maxRobotCount = maxRobotCount;
            this.robotDefaults = new ArrayList<>();

        }

    }




    public RobotDefault createRobot(Point point) throws RobotCreationException {
        final MapPoint robotPosition;
        try {

            validatePoint(point);
            robotPosition = new MapPoint(point.getX(), point.getY());
        } catch (PointValidationException e) {
            throw new RobotCreationException(e.getMessage());
        }

        RobotDefault robotDefault = new RobotDefault(robotPosition);
        robotDefaults.add(robotDefault);
        if(robotDefaults.size()> maxRobotCount){
            throw new RobotCreationException("Максимальное количество роботов привышено");
        }
        return robotDefault;
    }

    private void validatePoint(Point point) throws PointValidationException {

        for (Robot robot : robotDefaults) {

            if (point.equals(robot.getPoint())) {
                throw new PointValidationException("Позиция " + point + " занята другим роботом: " + robot);
            }
        }
    }


    public class RobotDefault implements Robot {

        public static final Direction DEFAULT_DIRECTION = Direction.TOP;
    private  static  Long idSequence = 1L;
        private final Long id;
        private MapPoint point;
        private Direction direction;

        public RobotDefault(MapPoint point) {
            this.id = idSequence++;
            this.point = point;
            this.direction = DEFAULT_DIRECTION;
        }

        public void move() throws RobotMoveException {
            final MapPoint newPoint;
            try {
                newPoint = switch (direction) {
                    case TOP -> new MapPoint(point.getX() - 1, point.getY());
                    case RIGHT -> new MapPoint(point.getX(), point.getY() + 1);
                    case BOTTOM -> new MapPoint(point.getX() + 1, point.getY());
                    case LEFT -> new MapPoint(point.getX(), point.getY() - 1);
                };

                validatePoint(newPoint);
            } catch (PointValidationException e) {
                throw new RobotMoveException(e.getMessage(), this);
            }

            this.point = newPoint;
        }
        public void move(int step)throws RobotMoveException {
            final MapPoint newPoint;
            try {
                newPoint = switch (direction) {
                    case TOP -> new MapPoint(point.getX() - step, point.getY());
                    case RIGHT -> new MapPoint(point.getX(), point.getY() + step);
                    case BOTTOM -> new MapPoint(point.getX() + step, point.getY());
                    case LEFT -> new MapPoint(point.getX(), point.getY() - step);
                };

                validatePoint(newPoint);
            } catch (PointValidationException e) {
                throw new RobotMoveException(e.getMessage(), this);
            }

            this.point = newPoint;

        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public MapPoint getPoint() {
            return point;
        }

        @Override
        public String toString() {
            return "Robot-" + id +" "+ point;
        }
    }

    public class MapPoint extends Point {

        public MapPoint(int x, int y) throws PointValidationException {
            super(x, y);

            if (x < 0 || x > n || y < 0 || y > m) {
                throw new PointValidationException("Недопустимое значение Point: " + this);
            }
        }
    }

}
