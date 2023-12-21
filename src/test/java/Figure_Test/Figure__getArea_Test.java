package Figure_Test;

import logic.Figure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class Figure__getArea_Test {
    private Figure figure;

    @Test
    @DisplayName("Figure getArea test passed")
    public void figureArea() {
        figure = new Figure();

        then(figure.getArea()).isNull();
    }
}
