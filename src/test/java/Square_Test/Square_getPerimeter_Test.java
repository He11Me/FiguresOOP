package Square_Test;

import logic.Point;
import consts.Consts;
import logic.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Square_getPerimeter_Test {
    private Square square;

    @Test
    @DisplayName("Square getPerimeter test passed")
    public void squarePerimeter() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "1"}),
                new Point(new String[]{"1", "0", "1"}),
                new Point(new String[]{"1", "1", "1"}),
                new Point(new String[]{"0", "1", "1"})
        ));

        square = new Square(points, Consts.FOUR_POINT, false);
        then(square.getPerimeter()).isEqualTo("4,00");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0"}),
                new Point(new String[]{"1", "1"}),
                new Point(new String[]{"0", "1"})
        ));
        square = new Square(points, Consts.FOUR_POINT, false);
        then(square.getPerimeter()).isEqualTo("4,00");

    }
}
