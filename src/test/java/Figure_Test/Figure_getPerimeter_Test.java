package Figure_Test;

import logic.Figure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class Figure_getPerimeter_Test {
    private Figure figure;

    @Test
    @DisplayName("Figure getPerimeter test passed")
    public void figurePerimeter() {
        figure = new Figure();

        then(figure.getPerimeter()).isNull();
    }
}
