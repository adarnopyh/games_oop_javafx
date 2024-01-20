package ru.job4j.chess.figures.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;


class BishopBlackTest {
    @Test
    void whenPosition() {
        BishopBlack BishopBlackMove = new BishopBlack(Cell.A5);
        assertThat(BishopBlackMove.position()).isEqualTo(Cell.A5);
    }

    @Test
    void whenCopy() {
        Cell cell = Cell.findBy(0, 5);
        BishopBlack BishopBlackMove = new BishopBlack(cell);
        Cell cellDest = BishopBlackMove.copy(cell).position();
        assertThat(cellDest).isEqualTo(cell);
    }

    @Test
    void whenWayUpRight() {
        BishopBlack BishopBlackMove = new BishopBlack(Cell.C1);
        Cell[] steps = new Cell[4];
        steps[0] = Cell.D2;
        steps[1] = Cell.E3;
        steps[2] = Cell.F4;
        steps[3] = Cell.G5;
        assertThat(BishopBlackMove.way(Cell.G5)).isEqualTo(steps);
    }

    @Test
    void whenWayDownRight() {
        BishopBlack BishopBlackMove = new BishopBlack(Cell.C7);
        Cell[] steps = new Cell[5];
        steps[0] = Cell.D6;
        steps[1] = Cell.E5;
        steps[2] = Cell.F4;
        steps[3] = Cell.G3;
        steps[4] = Cell.H2;
        assertThat(BishopBlackMove.way(Cell.H2)).isEqualTo(steps);
    }

    @Test
    void whenIsDiagonalIsTrue() {
        BishopBlack BishopBlackMove = new BishopBlack(Cell.C1);
        assertTrue(BishopBlackMove.isDiagonal(Cell.G5, Cell.D8));

    }
}
