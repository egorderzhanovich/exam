package by.techmeskills.figures.figuresfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Square extends Figure {

    private int width;

    public Square(double cx, double cy, double lineWidth) {
        super(FIGURE_TYPE_SQUARE, cx, cy, lineWidth);
    }

    public Square(double cx, double cy, double lineWidth, int width) {
        this(cx, cy, lineWidth);
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return width == square.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        Figure.setColor(graphicsContext);
        graphicsContext.strokeRect(cx, cy, width, width);
    }
}
