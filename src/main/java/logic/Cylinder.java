package logic;

import consts.Consts;

import java.util.ArrayList;

public class Cylinder extends Figure {

    private ArrayList<Integer> h_coordinates = new ArrayList<>();
    private ArrayList<Integer> downradius_coordinates = new ArrayList<>();
    private ArrayList<Integer> upradius_coordinates = new ArrayList<>();

    public Cylinder(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }
    private boolean checkCorner() {
        setCoords();

        return countingScalar(h_coordinates, downradius_coordinates) ||
                countingScalar(h_coordinates, upradius_coordinates);
    }

    private void setCoords() {
        if (h_coordinates.isEmpty() && downradius_coordinates.isEmpty() && upradius_coordinates.isEmpty()){
            h_coordinates = lineCords(Consts.FIRST, Consts.SECOND);
            downradius_coordinates = lineCords(Consts.THIRD, Consts.FIRST);
            upradius_coordinates = lineCords(Consts.THIRD, Consts.SECOND);
        }
    }


    public String getPerimeter() {
        return "The figure has no perimeter";
    }

    public String getArea() {
        double h = 0;
        double radius = 0;

        setCoords();

        if (countingScalar(h_coordinates, downradius_coordinates)) {
            h = lineLength(Consts.FIRST, Consts.SECOND);
            radius = lineLength(Consts.FIRST, Consts.THIRD);
        } else {
            h = lineLength(Consts.FIRST, Consts.SECOND);
            radius = lineLength(Consts.SECOND, Consts.THIRD);
        }


        return String.format("%.2f", Consts.TWO * Math.PI * radius * (radius + h));
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
