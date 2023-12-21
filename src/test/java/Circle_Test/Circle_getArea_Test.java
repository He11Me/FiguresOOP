package Circle_Test;

import logic.Point;
import consts.Consts;
import logic.Circle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Circle_getArea_Test {
    private Circle circle;

    @Test
    @DisplayName("Circle getArea test passed")
    public void circleArea() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0"})
        ));

        circle = new Circle(points, Consts.TWO_POINT, false);
        then(circle.getArea()).isEqualTo("3,14");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "1"})
        ));

        circle = new Circle(points, Consts.TWO_POINT, false);
        then(circle.getArea()).isEqualTo("6,28");
    }
}
