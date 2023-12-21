package Circle_Test;

import logic.Point;
import consts.Consts;
import logic.Circle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Circle_getPerimeter_Test {
    private Circle circle;

    @Test
    @DisplayName("Circle getPerimeter test passed")
    public void circlePerimeter () {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0"})
        ));

        circle = new Circle(points, Consts.TWO_POINT, false);
        then(circle.getPerimeter()).isEqualTo("6,28");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "1"})
        ));

        circle = new Circle(points, Consts.TWO_POINT, false);
        then(circle.getPerimeter()).isEqualTo("8,89");


    }
}
