package org.bob.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(3);
    }

    @Test
    public void testGetHeight() {
        assertEquals(3, board.getHeight());
    }

    @Test
    public void testGetTreeIsNull(){
        List<TupleBoolean> tree = board.getTree();
        assertNotNull(tree);
    }

    @Test
    public void testGetTree(){
        board.addLevel(new TupleBoolean(true, false));
        board.addLevel(new TupleBoolean(true, false));
        board.addLevel(new TupleBoolean(false, false));
        board.addLevel(new TupleBoolean(false, false));

        assertEquals(4, board.getTree().size());
    }

    @Test
    public void testAddLevel() {
        TupleBoolean level1 = new TupleBoolean(true, false);
        board.addLevel(level1);

        List<TupleBoolean> tree = board.getTree();
        assertEquals(1, tree.size());
        assertEquals(level1, tree.get(0));
    }

    @Test
    public void testDeleteLevel() {
        board.addLevel(new TupleBoolean(true, false));
        TupleBoolean level2 = new TupleBoolean(false, true);
        board.addLevel(level2);

        board.deleteLevel();
        assertEquals(1, board.getTree().size());
        assertEquals(level2, board.getTree().get(0));
    }

    @Test
    public void testClearBoard(){
        board.addLevel(new TupleBoolean(true, false));

        board.cleadBoard();
        assertEquals(0, board.getTree().size());
    }

    @Test
    public void testGetFirstLevel(){
        TupleBoolean level1 = new TupleBoolean(true, false);
        board.addLevel(level1);

        assertEquals(level1, board.getFirstLevel());
    }
}
