package org.example.demo;

public class SimpleRobot {

    // У каждого робота есть его позиция на двумерном поле (целочисленные координаты x и y)
    // По умолчанию робот находится в какой-то определнной позиции (0, 0)
    // Мы должны уметь перемещать робота на другую позицию с другими координатами
    // Робот должен уметь отдавать свое текщее положение

    public static final int DEFAULT_X_POSITION = 0;
    public static final int DEFAULT_Y_POSITION = 0;

    public static final SimpleRobot DEFAULT_POSITION = new SimpleRobot();

    private SimpleRobot point;

    public SimpleRobot() {
        this.point = DEFAULT_POSITION;
    }

    public void move(SimpleRobot point) {
        validatePoint(point);
        this.point = point;
    }

    private void validatePoint(SimpleRobot point) {
//        if (point.getX() < 0 || point.getY() < 0) {
//            throw new IllegalArgumentException();
//        }
    }

    public SimpleRobot getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Robot-" + point;
    }
}
