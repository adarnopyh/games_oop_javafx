package ru.job4j.chess;

import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LogicTest {


    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlackSource = new BishopBlack(Cell.C1);
        BishopBlack bishopBlackSource2 = new BishopBlack(Cell.D2);
        logic.add(bishopBlackSource2);
        logic.add(bishopBlackSource);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C1, Cell.G5);
        });
        assertThat(exception.getMessage()).isEqualTo("This way is occupied.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlackSource = new BishopBlack(Cell.C1);
        logic.add(bishopBlackSource);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.C1, Cell.G4);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from %s to %s", bishopBlackSource.position(), Cell.G4);
    }
}