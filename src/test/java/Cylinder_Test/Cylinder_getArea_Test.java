package Cylinder_Test;

import logic.Point;
import consts.Consts;
import logic.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Cylinder_getArea_Test {
    private Cylinder cylinder;

    @Test
    @DisplayName("Cylinder getArea test passed")
    public void cylinderArea() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"0", "0", "1"}),
                new Point(new String[]{"1", "0", "0"})
        ));
        cylinder = new Cylinder(points, Consts.THREE_POINT, true);
        then(cylinder.getArea()).isEqualTo("12,57");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"0", "0", "1"}),
                new Point(new String[]{"1", "0", "1"})
        ));

        cylinder = new Cylinder(points, Consts.THREE_POINT, true);
        then(cylinder.getArea()).isEqualTo("12,57");

    }
}
