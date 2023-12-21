package logic;

import consts.Consts;

import java.util.ArrayList;

public class Triangle extends Figure{

    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;

    public Triangle(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    public String getArea() {
        setLines();
        double per = (line1 + line2 + line3) / Consts.TWO;
        return String.format("%.2f", Math.sqrt(per * (per - line1) *
                (per - line2) * (per - line3)));

    }
    private void setLines () {
        if (line1 + line2 + line3 == 0) {
            line1 = lineLength(Consts.FIRST, Consts.SECOND);
            line2 = lineLength(Consts.SECOND, Consts.THIRD);
            line3 = lineLength(Consts.THIRD, Consts.FIRST);
        }
    }
    public double getAreaDouble() {
        setLines();
        double per = (line1 + line2 + line3) / Consts.TWO;
        return Math.sqrt(per * (per - line1) * (per - line2) * (per - line3));
    }

    public  String getPerimeter() {
        setLines();
        return String.format("%.2f", line1 + line2 + line3);
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
        if (super.isValid()) {
            setLines();
            return line1 < line2 + line3 && line2 < line1 + line3 && line3 < line1 + line2;
        }
        return false;
    }

    public boolean isFigure() {
        return false;
    }

}
