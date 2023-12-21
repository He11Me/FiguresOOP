package logic;

import consts.Consts;

import java.util.ArrayList;

public class Rectangle extends Figure{
    private double lineOne = 0;
    private double lineTwo  = 0;

    public Rectangle(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    private void setLines() {
        if (lineTwo + lineOne == 0) {
            lineOne = lineLength(Consts.FIRST, Consts.SECOND);
            lineTwo = lineLength(Consts.SECOND, Consts.THIRD);
        }
    }

    private boolean checkCorner() {
        ArrayList<Integer> width = lineCords(Consts.FIRST, Consts.SECOND);
        ArrayList<Integer> height = lineCords(Consts.THIRD, Consts.SECOND);
        return countingScalar(width, height);
    }
    public String getArea() {
        setLines();
        return String.format("%.2f", lineOne * lineTwo);
    }

    public  String getPerimeter() {
        setLines();
        return String.format("%.2f", Consts.TWO * (lineTwo + lineOne));
    }

    public ArrayList<Integer> lineCords(int first_point, int second_point) {
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(dots.get(first_point).getX() - dots.get(second_point).getX());
        coordinates.add(dots.get(first_point).getY() - dots.get(second_point).getY());
        coordinates.add(dots.get(first_point).getZ() - dots.get(second_point).getZ());

        return coordinates;
    }

    public boolean countingScalar(ArrayList<Integer> line1, ArrayList<Integer> line2) {
        return  line1.get(Consts.FIRST) * line2.get(Consts.FIRST) +
                line1.get(Consts.SECOND) * line2.get(Consts.SECOND) +
                line1.get(Consts.THIRD) * line2.get(Consts.THIRD) == 0;
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

    public  boolean isValid() {
        if (super.isValid()) {
            setLines();
            double line1 = lineOne;
            double line2 = lineTwo;
            double line3 = lineLength(Consts.THIRD, Consts.FOURTH);
            double line4 = lineLength(Consts.FOURTH, Consts.FIRST);

            return checkCorner() && line1 == line3 && line2 == line4 && line1 != line2;
        }

        return false;
    }

    public boolean isFigure() {
        return false;
    }
}
