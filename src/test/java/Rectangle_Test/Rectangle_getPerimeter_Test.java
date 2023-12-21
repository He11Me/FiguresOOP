package Rectangle_Test;

import logic.Point;
import consts.Consts;
import logic.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Rectangle_getPerimeter_Test {
    private Rectangle rectangle;

    @Test
    @DisplayName("Rectangle getPerimeter test passed")
    public void rectanglePerimeter() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"2", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"0", "1", "0"})
        ));
        rectangle = new Rectangle(points, Consts.FOUR_POINT, false);
        then(rectangle.getPerimeter()).isEqualTo("6,00");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"2", "0"}),
                new Point(new String[]{"2", "1"}),
                new Point(new String[]{"0", "1"})
        ));
        rectangle = new Rectangle(points, Consts.FOUR_POINT, false);
        then(rectangle.getPerimeter()).isEqualTo("6,00");
    }
}
