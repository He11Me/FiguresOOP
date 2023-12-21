package logic;

import consts.Consts;

import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends Figure {

    public Polygon(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    public String getPerimeter() {
        double perimeter = 0;
        for (int i = 0; i < dots.size() - 1; ++i) {
            perimeter += lineLength(i, i + 1);
        }

        perimeter += lineLength(Consts.FIRST, dots.size() - 1);


        return String.format("%.2f", perimeter);
    }
    @Override
    public String getArea() {
        double area = 0;
        Point main = dots.get(0);

        for (int i = 1; i < dots.size() - 1; i++) {
            Triangle tr = new Triangle(new ArrayList<Point>(Arrays.asList(
                    main,
                    dots.get(i),
                    dots.get(i + 1)
            )), Consts.THREE_POINT, true);

            area += tr.getAreaDouble();
        }

        return String.format("%.2f", area);
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
        double endLine = lineLength(Consts.FIRST, dots.size() - 1);

        return !String.format("%.2f", Consts.TWO * endLine).equals(getPerimeter())
                && (dots.size() >= Consts.THREE) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
