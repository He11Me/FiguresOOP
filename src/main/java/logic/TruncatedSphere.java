package logic;

import consts.Consts;

import java.util.ArrayList;

public class TruncatedSphere extends Figure{
    private double radius = 0;
    public TruncatedSphere(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    private void setRadius() {
        if (radius == 0) {
            radius = lineLength(Consts.FIRST, Consts.SECOND);
        }
    }

    public String getArea() {
        setRadius();
        double truncRadius = Math.sqrt(Math.pow(radius, Consts.TWO) -
                Math.pow(dots.get(Consts.THIRD).getZ(), Consts.TWO));
        double h = radius - dots.get(Consts.THIRD).getZ();
        double truncArea = 2 * Math.PI * radius * h;
        double area = 4 * Math.PI * Math.pow(radius, Consts.TWO) -
                truncArea + Math.PI * Math.pow(truncRadius, Consts.TWO);

        return String.format("%.2f", area);
    }

    public String getPerimeter() {
        return "The figure has no perimeter";
    }

    public boolean isValid() {
        if (super.isValid()) {
            setRadius();
            double checkRadius = lineLength(Consts.FIRST, Consts.THIRD);
            return checkRadius <= radius;
        }

        return false;

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

    public boolean isFigure() {
        return false;
    }
}
