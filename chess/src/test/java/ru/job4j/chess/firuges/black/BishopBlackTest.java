package ru.job4j.chess.firuges.black;


import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void samePositionWhenStart() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(Cell.C1, bishopBlack.position());
    }

    @Test
    public void whenCopyTrue() {
        BishopBlack bishopBlackC1 = new BishopBlack(Cell.C1);
        BishopBlack bishopBlackA3 = new BishopBlack(Cell.A3);
        assertEquals(bishopBlackA3.position(), bishopBlackC1.copy(Cell.A3).position());
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayDiagonalException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.A2);
        throw new ImpossibleMoveException(
                String.format("Could not way by diagonal from %s to %s",
                        Cell.A2, Cell.A4));
    }

    @Test
    public void WhenWayC1ToG5True() {
        BishopBlack bishopBlackC1 = new BishopBlack(Cell.C1);
        assertThat(bishopBlackC1.way(Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }
}