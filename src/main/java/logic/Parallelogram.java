package logic;

import consts.Consts;

import java.util.ArrayList;

public class Parallelogram extends Figure {
    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;
    private double line4 = 0;

    public Parallelogram(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    public String getArea() {
        ArrayList<Point> pointsT = new ArrayList<>(dots);

        pointsT.remove(0);

        Triangle tr = new Triangle(pointsT, Consts.THREE_POINT, false);
        return String.format("%.2f", tr.getAreaDouble() * Consts.TWO);

    }

    public String getPerimeter () {
        setLines();
        return String.format("%.2f", line1 + line2 + line3 + line4);

    }

    private void setLines() {
        if (line1 + line2 + line3 + line4 == 0) {
            this.line1 = lineLength(Consts.FIRST, Consts.SECOND);
            this.line2 = lineLength(Consts.SECOND, Consts.THIRD);
            this.line3 = lineLength(Consts.THIRD, Consts.FOURTH);
            this.line4 = lineLength(Consts.FOURTH, Consts.FIRST);
        }
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
            return line1 == line3 && line2 == line4 && line1 != line2 && line3 != line4;
        }

        return false;
    }

    public boolean isFigure() {
        return false;
    }
}
