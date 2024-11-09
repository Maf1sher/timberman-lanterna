package org.bob.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTupleBoolean {

    @Test
    public void testTupleBoolean() {
        TupleBoolean tuple1 = new TupleBoolean(true, true);
        assertTrue(tuple1.getValue1());
        assertTrue(tuple1.getValue2());

        TupleBoolean tuple2 = new TupleBoolean(false, false);
        assertFalse(tuple2.getValue1());
        assertFalse(tuple2.getValue2());

        TupleBoolean tuple3 = new TupleBoolean(true, false);
        assertTrue(tuple3.getValue1());
        assertFalse(tuple3.getValue2());

        TupleBoolean tuple4 = new TupleBoolean(false, true);
        assertFalse(tuple4.getValue1());
        assertTrue(tuple4.getValue2());
    }
}
