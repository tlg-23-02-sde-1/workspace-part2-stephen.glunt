package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class TelevisionTest {
    private final int MIN_VOLUME = 0;
    private final int MAX_VOLUME = 100;
    private final int MIN_CHANNEL = 1;
    public final int MAX_CHANNEL = 999;
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 50);
        tv2 = new Television("Sony", 50);
    }

    @Test
    public void compareTo_shouldReturnNegative_whenComesFirstInNaturalOrder(){
        tv1.setBrand("RCA");
        assertTrue(tv1.compareTo(tv2) < 0);
    }

    @Test
    public void compareTo_shouldReturnZero_whenBrandIsSame(){
        tv1.setVolume(75);
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldReturnPositive_whenComesNextInNaturalOrder(){
        tv1.setBrand("Zenith");
        assertTrue(tv1.compareTo(tv2) > 0);
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_LowerBound() throws InvalidChannelException {
        tv1.changeChannel(MIN_CHANNEL);
        assertEquals(MIN_CHANNEL, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_UpperBound() throws InvalidChannelException {
        tv1.changeChannel(MAX_CHANNEL);
        assertEquals(MAX_CHANNEL, tv1.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowException_whenInvalid_LowerBound() throws InvalidChannelException {
        tv1.changeChannel(MIN_CHANNEL - 1);
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowException_whenInvalid_UpperBound() throws InvalidChannelException {
        tv1.changeChannel(MAX_CHANNEL + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowException_forValuesLessThanMin() {
        tv1.setVolume(MIN_VOLUME - 1);
    }

    @Test
    public void setVolume_shouldThrowException_forValuesGreaterThanMax() {
        try {
            tv1.setVolume(MAX_VOLUME + 1);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(String.format("Invalid volume: %s. Allowed range: [%s,%s].",
                    MAX_VOLUME + 1, MIN_VOLUME, MAX_VOLUME), e.getMessage());
        }
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_LowerBound() {
        tv1.setVolume(MIN_VOLUME);
        assertEquals(MIN_VOLUME, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_UpperBound() {
        tv1.setVolume(MAX_VOLUME);
        assertEquals(MAX_VOLUME, tv1.getVolume());
    }


    @Test
    public void hashCode_shouldBeSame_whenEqualTvs() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void equals_shouldBeTrue_whenBrandVolumeDisplayAreSame() {
        tv1.setDisplay(DisplayType.valueOf("LCD"));
        tv2.setDisplay(DisplayType.LCD);
        assertTrue(tv1.equals(tv2));
    }

    @Test
    public void equals_shouldBeFalse_whenBranDiffers(){
        tv1.setBrand("LG");
        assertFalse(tv1.equals(tv2));
    }

    @Test
    public void equals_shouldBeFalse_whenVolumeDiffers(){
        tv2.setVolume(15);
        assertFalse(tv1.equals(tv2));
    }

    @Test
    public void equals_shouldBeFalse_whenDisplayDiffers(){
        tv1.setDisplay(DisplayType.LCD);
        assertFalse(tv1.equals(tv2));
    }
}