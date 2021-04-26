package by.techmeskills.figures.figuresfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rectangle extends Figure {

    private double width;
    private double height;

    public Rectangle(double cx, double cy, double lineWidth) {
        super(Figure.FIGURE_TYPE_RECTANGLE, cx, cy, lineWidth);
    }

    public Rectangle(double cx, double cy, double lineWidth, double width, double height) {
        this(cx, cy, lineWidth);
        this.width = width < 20 ? 20 : width;
        this.height = height < 30 ? 30 : height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        Figure.setColor(graphicsContext);
        graphicsContext.strokeRect(cx - width / 2, cy - height / 2, width, height);
    }
}
