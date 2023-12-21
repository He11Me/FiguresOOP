package Cone_Test;

import logic.Point;
import consts.Consts;
import logic.Cone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Cone_isValid_Test {
    private Cone cone;

    @Test
    @DisplayName("Cone isValid test passed")
    public void coneValid() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"0", "0", "1"})
        ));

        cone = new Cone(points, Consts.THREE_POINT, true);
        then(cone.isValid()).isTrue();

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"1", "0", "1"})
        ));

        cone = new Cone(points, Consts.THREE_POINT, true);

        then(cone.isValid()).isFalse();

    }
}
