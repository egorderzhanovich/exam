package by.techmeskills.figures.customExceptions;

import by.techmeskills.figures.figuresfx.Figure;

public class UnknownFigureException extends Exception {
    public UnknownFigureException(String message) {
        super(message);
    }
}
