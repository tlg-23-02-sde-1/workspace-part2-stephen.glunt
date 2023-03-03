package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionBrandChannelComparator comp;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony", 15, DisplayType.LCD);
        tv2 = new Television("Sony", 15, DisplayType.LCD);
        tv1.changeChannel(5);
        tv2.changeChannel(5);
        comp = new TelevisionBrandChannelComparator();
    }

    @Test
    public void compare_shouldReturnZero_whenTvsBrandAndChannelAreSame()  {
        assertEquals(0, comp.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnNegative_whenTv1BrandIsLess() throws InvalidChannelException {
        tv1.setBrand("RCA");
        assertTrue(comp.compare(tv1, tv2) < 0);
        tv1.changeChannel(8);
        assertTrue(comp.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldReturnPositive_whenTv1BrandIsGreater() throws InvalidChannelException {
        tv1.setBrand("Zenith");
        assertTrue(comp.compare(tv1, tv2) > 0);
        tv1.changeChannel(4);
        assertTrue(comp.compare(tv1, tv2) > 0);
    }

    @Test
    public void compare_shouldReturnNegative_whenTv1ChannelIsLess() throws InvalidChannelException {
        tv1.changeChannel(4);
        assertTrue(comp.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldReturnNegatie_whenTv1ChannelIsGreater() throws InvalidChannelException {
        tv1.changeChannel(6);
        assertTrue(comp.compare(tv1, tv2) > 0);
    }
}