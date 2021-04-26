package by.techmeskills.figures.drawutils;

import by.techmeskills.figures.figuresfx.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer<T extends Figure & Drawable> {
    private ArrayList<Figure> figures;

    public Drawer(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext graphicsContext) {
        for (Figure figure : figures) {
            if (figure != null) {
                figure.draw(graphicsContext);
            }
        }
    }
}
