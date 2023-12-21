package logic;

import consts.Consts;

import java.util.ArrayList;

public class Cone extends Figure {

    public Cone(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    private boolean checkCorner() {
        ArrayList<Integer> h_coordinates = lineCords(Consts.FIRST, Consts.SECOND);
        ArrayList<Integer> radius_coordinates = lineCords(Consts.THIRD, Consts.FIRST);
        return countingScalar(h_coordinates, radius_coordinates);

    }

    public String getArea() {
        double radius = lineLength(Consts.FIRST, Consts.SECOND);
        double h = lineLength(Consts.SECOND, Consts.THIRD);
        return String.format("%.2f", Math.PI * radius * (h + radius));
    }

    public String getPerimeter() {
        return "The figure has no perimeter";
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

    public boolean isValid() {
        return super.isValid() && checkCorner();
    }

    public boolean isFigure() {
        return false;
    }
}
