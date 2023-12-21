package TruncatedSphere_Test;

import logic.Point;
import consts.Consts;
import logic.TruncatedSphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class TruncatedSphere_getArea_Test {
    private TruncatedSphere sphere;

    @Test
    @DisplayName("TrSphere getArea test passed")
    public void TruncatedSpehreTestArea() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"0", "0", "4"}),
                new Point(new String[]{"1", "0", "2"})
        ));
        sphere = new TruncatedSphere(points, Consts.THREE_POINT, true);
        then(sphere.getArea()).isEqualTo("188,50");
    }
}
