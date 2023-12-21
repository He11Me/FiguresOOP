import logic.Point;
import consts.Consts;
import logic.*;

import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            Figure figure = chooseTheFigure();

            if (figure.isFigure()) {
                System.out.println("The figure is a figure");
                System.out.println("The figure has no area");
                System.out.println("The figure has no perimeter");
            } else if (figure.isValid()) {
                System.out.println("The figure is valid");
                System.out.println("The figure area " + figure.getArea());
                if (figure.getIsOnlyThreePoint()) {
                    System.out.println(figure.getPerimeter());
                } else {
                    System.out.println("The figure perimeter " + figure.getPerimeter());
                }

            } else {
                System.out.println("The figure is invalid");
            }

        }
    }

    private static Figure chooseTheFigure() {

        String command = scanner.nextLine();

        while (!command.matches("FIGURE|CIRCLE|SQUARE|RECTANGLE|PARALLELOGRAM|" +
                "TRIANGLE|POLYGON|SPHERE|TRUNCATED_SPHERE|CYLINDER|CONE")) {
            if (command.equals("END")) {
                System.exit(0);
            } else {
                System.out.println("Please, retype");
                command = scanner.nextLine();
            }

        }

        ArrayList<Point> points = points();

        switch (command) {
            case "CIRCLE":
                return new Circle(points, Consts.TWO_POINT, false);
            case "SQUARE":
                return new Square(points, Consts.FOUR_POINT, false);
            case "RECTANGLE":
                return new Rectangle(points, Consts.FOUR_POINT, false);
            case "TRIANGLE":
                return new Triangle(points, Consts.THREE_POINT, false);
            case "PARALLELOGRAM":
                return new Parallelogram(points, Consts.FOUR_POINT, false);
            case "POLYGON":
                return new Polygon(points, points.size() , false);
            case "SPHERE":
                return new Sphere(points, Consts.TWO_POINT, true);
            case "TRUNCATED_SPHERE":
                return new TruncatedSphere(points, Consts.THREE_POINT, true);
            case "CYLINDER":
                return new Cylinder(points, Consts.THREE_POINT, true);
            case "CONE":
                return new Cone(points, Consts.THREE_POINT, true);
            default:
                return new Figure();
        }

    }

    private static ArrayList<Point> points() {
        ArrayList<Point> POINTS = new ArrayList<>();

        String coords = scanner.nextLine();

        while (!coords.equals("STOP_INPUT")) {
            if (coords.matches("(-?\\d+ -?\\d+ -?\\d+)|(-?\\d+ -?\\d+)")) {
                String[] p = coords.split(" ");
                POINTS.add(new Point(p));
            } else {
                System.out.println("Please, retype");
            }

            coords = scanner.nextLine();
        }

        return POINTS;
    }
}
