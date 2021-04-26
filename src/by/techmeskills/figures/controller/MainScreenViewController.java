package by.techmeskills.figures.controller;

import by.techmeskills.figures.customExceptions.UnknownFigureException;
import by.techmeskills.figures.drawutils.Drawer;
import by.techmeskills.figures.figuresfx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);
    private int typeOfFigure = 0;
    private ArrayList<Figure> figures = new ArrayList<>();
    private Random random;
    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DOMConfigurator.configure("src/log4j");
        logger.info("App has started");
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y, int typeOfFigure) throws UnknownFigureException {
        Figure figure = null;
        switch (typeOfFigure) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(3), random.nextInt(50) + 20);
                break;

            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(3), random.nextInt(50), random.nextInt(100));
                break;

            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(3), x - 75, x + 75, random.nextInt(100) + y, random.nextInt(100) + y);
                break;
            case Figure.FIGURE_TYPE_SQUARE:
                figure = new Square(x, y, random.nextInt(3), random.nextInt(75) + 20);
                break;
            case Figure.FIGURE_TYPE_PENTAGON:
                double cx2 = x + 25;
                double cx3 = x + 75;
                double cx4 = x + 100;
                double cx5 = x + 50;
                double cy2 = y + 40;
                double cy3 = y + 40;
                double cy4 = y;
                double cy5 = y - 40;
                figure = new Pentagon(x, y, random.nextInt(3), new double[]{x, cx2, cx3, cx4, cx5}, new double[]{y, cy2, cy3, cy4, cy5});
                break;
            default:
                throw new UnknownFigureException("Unknown type of figure");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());

    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY(), typeOfFigure));
        } catch (UnknownFigureException e) {
            logger.error("Exception", e);
        }
        repaint();

    }


    @FXML
    private void drawTriangle() {
        typeOfFigure = 2;
    }

    @FXML
    private void exit() {
        logger.info("Application is shut down");
        System.exit(0);
    }

    public void drawPentagon() {
        typeOfFigure = 4;
    }

    public void drawCircle() {
        typeOfFigure = 0;
    }

    public void drawRectangle() {
        typeOfFigure = 1;
    }

    public void drawSquare() {
        typeOfFigure = 3;
    }

    public void randomFigure() {
        typeOfFigure = random.nextInt(6);
    }

}
