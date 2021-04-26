package by.techmeskills.figures.figuresfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    double cx2,cx3,cy2,cy3;

    public Triangle(double cx, double cy, double lineWidth) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth);
    }

    public Triangle(double cx, double cy, double lineWidth, double cx2, double cx3, double cy2, double cy3) {
        this(cx, cy, lineWidth);
        this.cx2 = cx2;
        this.cx3 = cx3;
        this.cy2 = cy2;
        this.cy3 = cy3;
    }

    public double getCx2() {
        return cx2;
    }

    public double getCx3() {
        return cx3;
    }

    public double getCy2() {
        return cy2;
    }

    public double getCy3() {
        return cy3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.cx2, cx2) == 0 &&
                Double.compare(triangle.cx3, cx3) == 0 &&
                Double.compare(triangle.cy2, cy2) == 0 &&
                Double.compare(triangle.cy3, cy3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cx2, cx3, cy2, cy3);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        Figure.setColor(graphicsContext);
        graphicsContext.strokePolygon(new double[]{cx,cx2,cx3},new double[]{cy,cy2,cy3},3);
    }
}
