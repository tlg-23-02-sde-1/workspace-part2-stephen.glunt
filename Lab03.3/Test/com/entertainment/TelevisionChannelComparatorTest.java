package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionChannelComparator comp;

    @Before
    public void setUp()  {
        tv1 = new Television("Sony", 15, DisplayType.LCD);
        tv2 = new Television("Sony", 15, DisplayType.LCD);
        comp = new TelevisionChannelComparator();
    }

    @Test
    public void compare_shouldReturnZero_whenTvsChannelIsSame() throws InvalidChannelException {
        tv1.changeChannel(5);
        tv2.changeChannel(5);
        assertEquals(0, comp.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnNegative_whenTv1ChannelIsLess() throws InvalidChannelException {
        tv1.changeChannel(5);
        tv2.changeChannel(6);
        assertTrue(comp.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldReturnPositive_whenTv1ChannelIsGreater() throws InvalidChannelException {
        tv1.changeChannel(8);
        tv2.changeChannel(5);
        assertTrue(comp.compare(tv1, tv2) > 0);
    }
}