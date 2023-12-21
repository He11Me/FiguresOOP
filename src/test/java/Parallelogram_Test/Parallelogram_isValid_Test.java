package Parallelogram_Test;

import logic.Point;
import consts.Consts;
import logic.Parallelogram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Parallelogram_isValid_Test {
    private Parallelogram parallelogram;

    @Test
    @DisplayName("Parallelogram isValid test passed")
    public void parallelogramTest() {

        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"1", "1", "0"})
        ));
        parallelogram = new Parallelogram(points, Consts.FOUR_POINT, true);
        then(parallelogram.isValid()).isTrue();

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0"}),
                new Point(new String[]{"2", "1"}),
                new Point(new String[]{"1", "1"})
        ));
        parallelogram = new Parallelogram(points, Consts.FOUR_POINT, false);
        then(parallelogram.isValid()).isTrue();

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"4", "0", "0"}),
                new Point(new String[]{"3", "1", "0"}),
                new Point(new String[]{"1", "1", "0"})
        ));
        parallelogram = new Parallelogram(points, Consts.FOUR_POINT, true);
        then(parallelogram.isValid()).isFalse();
        
    }
}
