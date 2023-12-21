package logic;

import consts.Consts;

import java.util.ArrayList;

public class Square extends Figure {
    private double line = 0;

    public Square(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }
    private void setLine() {
        if (line == 0) {
            line = lineLength(Consts.FIRST, Consts.SECOND);
        }
    }
    private boolean checkCorner() {
        ArrayList<Integer> width= lineCords(Consts.FIRST, Consts.SECOND);
        ArrayList<Integer> height = lineCords(Consts.THIRD, Consts.SECOND);
        return countingScalar(width, height);
    }

    public String getArea() {
        setLine();
        return String.format("%.2f", Math.pow(line, Consts.TWO));
    }

    public String getPerimeter() {
        setLine();
        return String.format("%.2f", line * Consts.FOUR);
    }

    public ArrayList<Integer> lineCords(int first_point, int second_point) {
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(dots.get(first_point).getCordX() - dots.get(second_point).getCordX());
        coordinates.add(dots.get(first_point).getCordY() - dots.get(second_point).getCordY());
        coordinates.add(dots.get(first_point).getCordZ() - dots.get(second_point).getCordZ());

        return coordinates;
    }

    public boolean countingScalar(ArrayList<Integer> line1, ArrayList<Integer> line2) {
        return  line1.get(Consts.FIRST) * line2.get(Consts.FIRST) +
                line1.get(Consts.SECOND) * line2.get(Consts.SECOND) +
                line1.get(Consts.THIRD) * line2.get(Consts.THIRD) == 0;
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

    public  boolean isValid() {
        if (super.isValid()) {
            setLine();
            double firstLine = line;
            double secondLine = lineLength(Consts.FOURTH, Consts.FIRST);

            for (int i = 1; i < dots.size() - 1; ++i) {
                double l = lineLength(i, i + 1);
                if (firstLine != l) {
                    return false;
                }
            }

            return checkCorner() && firstLine == secondLine;
        }

        return false;
    }

    public boolean isFigure() {
        return false;
    }
}
