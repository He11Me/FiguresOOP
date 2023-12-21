package logic;

import consts.Consts;

import java.util.ArrayList;

public class Sphere extends Figure{

    public Sphere(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    public String getPerimeter() {
        return "The figure has no perimeter";

    }

    public String getArea() {
        double radius = lineLength(Consts.FIRST, Consts.SECOND);
        return String.format("%.2f", Consts.FOUR * Math.PI * Math.pow(radius, Consts.TWO));
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

    public boolean isValid() {
       return super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
