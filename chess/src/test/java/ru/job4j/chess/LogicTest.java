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

    @Test(expected = OccupiedCellException.class)
    public void whenOccupiedCellException()  throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.add(new PawnBlack(Cell.B2));
            logic.move(Cell.C1, Cell.B2);
           }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.move(Cell.C1, Cell.C3);

    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundException() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C2));
        logic.move(Cell.C1, Cell.C2);

    }
}