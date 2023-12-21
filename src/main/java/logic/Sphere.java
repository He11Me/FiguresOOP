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
                calculatingCord(dots.get(first_point).getCordX(), dots.get(second_point).getCordX())
                + calculatingCord(dots.get(first_point).getCordY(), dots.get(second_point).getCordY())
                + calculatingCord(dots.get(first_point).getCordZ(), dots.get(second_point).getCordZ()));
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
