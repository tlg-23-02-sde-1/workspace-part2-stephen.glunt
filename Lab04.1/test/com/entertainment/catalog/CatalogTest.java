/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_whenBrandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertTrue(tvs.isEmpty());
    }

    @Test
    public void findByBrand_shouldReturnCollection_withAllMatchingBrands() {
        String brand = "Sony";
        Collection<Television> tvs = Catalog.findByBrand(brand);
        assertEquals(7, tvs.size());
        for(var item : tvs){
            assertEquals(brand, item.getBrand());
        }
    }

    @Test
    public void findByBrands_shouldReturnEmptyMap_whenNoBrandsPassed(){
        Map<String, Collection<Television>> tvs = Catalog.findByBrands();
        assertTrue(tvs.isEmpty());
    }

    @Test
    public void findByBrands_shouldReturnMap_WithEntryForEachBrandSupplied() {
        String[] brands = {"Sony", "RCA", "Zenith", "D", "E"};
        Map<String, Collection<Television>> tvs = Catalog.findByBrands(brands);
        assertEquals(brands.length, tvs.size());
        for(var brand : brands) {
            assertTrue(tvs.containsKey(brand));
        }
        for(var brand : brands) {
            Collection<Television> sonyTvs = tvs.get(brand);
            int size = Catalog.findByBrand(brand).size();
            assertEquals(size, sonyTvs.size());
            for(var tv : sonyTvs){
                assertEquals(brand, tv.getBrand());
            }
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getInventory_shouldBreak_whenTryingToEditInventory(){
        Collection<Television> myCat = Catalog.getInventory();
        myCat.clear();
    }

    @Test
    public void removeDuplicates_shouldRemoveAllDuplicates(){
        Set<Television> tvs = new HashSet<>(Catalog.getInventory());
        Television previous = null;
        for(var tv : tvs){
            assertFalse(tv.equals(previous));
        }
    }

    @Test
    public void findLoudest_shouldFindLoudest_inInventory(){
        int loudestVolume = 0;
        Television loudest = null;
        for(var tv : Catalog.getInventory()){
            if(tv.getVolume() > loudestVolume){
                loudestVolume = tv.getVolume();
                loudest = tv;
            }
        }
        assertEquals(loudestVolume, loudest.getVolume());
    }
}