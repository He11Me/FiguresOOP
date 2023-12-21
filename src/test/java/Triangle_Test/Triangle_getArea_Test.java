package Triangle_Test;

import logic.Point;
import consts.Consts;
import logic.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Triangle_getArea_Test {
    private Triangle triangle;

    @Test
    @DisplayName("Triangle getArea test passed")
    public void triangleArea() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"1", "2"}),
                new Point(new String[]{"2", "4"}),
                new Point(new String[]{"3", "2"})
        ));
        triangle = new Triangle(points, Consts.THREE_POINT, false);
        then(triangle.getArea()).isEqualTo("2,00");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"1", "2", "1"}),
                new Point(new String[]{"2", "4", "1"}),
                new Point(new String[]{"3", "2", "1"})
        ));
        triangle = new Triangle(points, Consts.THREE_POINT, false);
        then(triangle.getArea()).isEqualTo("2,00");

    }
}
