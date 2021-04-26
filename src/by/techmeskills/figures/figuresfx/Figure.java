package by.techmeskills.figures.figuresfx;

import by.techmeskills.figures.drawutils.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class Figure implements Drawable {
    public static final int FIGURE_TYPE_CIRCLE = 0;
    public static final int FIGURE_TYPE_RECTANGLE = 1;
    public static final int FIGURE_TYPE_TRIANGLE = 2;
    public static final int FIGURE_TYPE_SQUARE = 3;
    public static final int FIGURE_TYPE_PENTAGON = 4;

    private int type;

    protected double cx;
    protected double cy;
    protected double lineWidth;

    public Figure(int type, double cx, double cy, double lineWidth) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWidth = lineWidth;
    }

    public double getCx() {
        return cx;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }


    public int getType() {
        return type;
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public static void setColor(GraphicsContext graphicsContext) {
        float red = (float) Math.random() * 1;
        float green = (float) Math.random() * 1;
        float blue = (float) Math.random() * 1;
        graphicsContext.setStroke(new Color(red, green, blue, 1));

    }
}
