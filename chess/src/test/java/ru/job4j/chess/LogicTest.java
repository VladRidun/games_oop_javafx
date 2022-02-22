package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;


import static org.junit.Assert.*;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void whenOccupiedCellException() {
        Exception exception = assertThrows(OccupiedCellException.class, () -> {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.add(new PawnBlack(Cell.B2));
            logic.move(Cell.C1, Cell.B2);
        });
        String expectedMessage = "Could not move! Cell is occupied.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenImpossibleMoveException() {
        Exception exception = assertThrows(ImpossibleMoveException.class, () -> {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.move(Cell.C1, Cell.C3);
        });
        String expectedMessage = String.format("Could not move by diagonal from %s to %s",
                Cell.C1, Cell.C3);
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenFigureNotFoundException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C2));
        Exception exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.C1);
        });
        assertNull(null);
    }
}