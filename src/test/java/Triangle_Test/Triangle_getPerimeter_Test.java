package Triangle_Test;

import logic.Point;
import consts.Consts;
import logic.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Triangle_getPerimeter_Test {
    private Triangle triangle;

    @Test
    @DisplayName("Triangle getPerimeter test passed")
    public void trianglePerimeter() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"1", "2"}),
                new Point(new String[]{"2", "4"}),
                new Point(new String[]{"3", "2"})
        ));
        triangle = new Triangle(points, Consts.THREE_POINT, false);
        then(triangle.getPerimeter()).isEqualTo("6,47");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"1", "2", "1"}),
                new Point(new String[]{"2", "4", "1"}),
                new Point(new String[]{"3", "2", "1"})
        ));
        triangle = new Triangle(points, Consts.THREE_POINT, false);
        then(triangle.getPerimeter()).isEqualTo("6,47");

    }
}
