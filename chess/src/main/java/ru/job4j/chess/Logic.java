package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int i = findBy(source);
        Cell[] steps = figures[i].way(dest);
        free(steps);
        figures[i] = figures[i].copy(dest);
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (Figure figure : figures) {
            for (Cell step : steps) {
                if (step.equals(figure.position())) {
                    throw new OccupiedCellException("This way is occupied.");
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int i = 0; i != figures.length; i++) {
            Figure figure = figures[i];
            if (figure != null && figure.position().equals(cell)) {
                return i;
            }
        }
        throw new FigureNotFoundException("Figure not found on the board.");

    }
}
