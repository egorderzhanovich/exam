package by.techmeskills.figures.figuresfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Circle extends Figure {

    private double radius;

    private Circle(double cx, double cy, double lineWidth) {
        super(FIGURE_TYPE_CIRCLE, cx, cy, lineWidth);
    }

    public Circle(double cx, double cy, double lineWidth, double radius) {
        this(cx, cy, lineWidth);
        this.radius = radius;
    }

    public Circle(int type, double cx, double cy, double lineWidth, double radius) {
        super(type, cx, cy, lineWidth);
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                '}';
    }
}
