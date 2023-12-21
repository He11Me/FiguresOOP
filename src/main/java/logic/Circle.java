package logic;

import consts.Consts;

import java.util.ArrayList;

public class Circle extends Figure {
    private double radius = 0;

    public Circle(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    @Override
    public String getArea() {
        setRadius();
        double area = Math.PI * Math.pow(radius, Consts.TWO);
        return String.format("%.2f", area);
    }

    @Override
    public String getPerimeter() {
        setRadius();
        double per = 2 * Math.PI * radius;
        return String.format("%.2f", per);
    }

    private void setRadius() {
        if (radius == 0) {
            radius = lineLength(Consts.FIRST, Consts.SECOND);
        }
    }

    public double lineLength (int first_point, int second_point) {
        return Math.sqrt(
                calculatingCord(dots.get(first_point).getX(), dots.get(second_point).getX())
                + calculatingCord(dots.get(first_point).getY(), dots.get(second_point).getY())
                + calculatingCord(dots.get(first_point).getZ(), dots.get(second_point).getZ()));
    }

    public double calculatingCord (int first_cord, int second_cord) {
        return Math.pow(first_cord - second_cord, Consts.TWO);
    }

    @Override
    public boolean isValid() {
        return super.isValid();
    }

    @Override
    public boolean isFigure() {
        return false;
    }
}
