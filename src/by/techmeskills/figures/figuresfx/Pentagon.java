package by.techmeskills.figures.figuresfx;

import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;

public class Pentagon extends Figure{
    double[] xPoints;
    double[] yPoints;
    public Pentagon(double cx, double cy, double lineWidth) {
        super(Figure.FIGURE_TYPE_PENTAGON, cx, cy, lineWidth);
    }

    public Pentagon(double cx, double cy, double lineWidth, double[] xPoints, double[] yPoints) {
        this(cx,cy,lineWidth);
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pentagon)) return false;
        Pentagon pentagon = (Pentagon) o;
        return Arrays.equals(xPoints, pentagon.xPoints) &&
                Arrays.equals(yPoints, pentagon.yPoints);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(xPoints);
        result = 31 * result + Arrays.hashCode(yPoints);
        return result;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        Figure.setColor(graphicsContext);
        graphicsContext.strokePolygon(xPoints,yPoints,5);
    }
}
