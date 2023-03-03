package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() throws Exception {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(1000L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItem_whenIdFound() {
        MusicItem item = catalog.findById(12L);
        assertTrue(item.getId() == 12);
    }

    @Test
    public void findByKeyword_shouldReturnEmptyCollection_whenNoResults() {
        Collection<MusicItem> items = catalog.findByKeyword("INVALID");
        assertTrue(items.isEmpty());
    }

    @Test
    public void findByKeyword_shouldReturnCollectionsOfItems_withKeyWordInTitleOrArtist() {
        Collection<MusicItem> items = catalog.findByKeyword("li");
        assertTrue(items.size() == 3);
        for (var item : items) {
            assertTrue(item.getTitle().toLowerCase().contains("Li".toLowerCase()));
        }
        items = catalog.findByKeyword("Seal");
        assertTrue(items.size() == 1);
        List<MusicItem> itemList = new ArrayList<>(items);
        assertTrue(itemList.get(0).getArtist().equals("Seal"));
    }

    @Test
    public void findByCategory_shouldReturnCollectionOfItems_thatMatchGenre() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        assertTrue(items.size() == 4);
        for(var item : items){
            assertTrue(item.getMusicCategory().equals(MusicCategory.POP));
        }
    }

    @Test
    public void findByCategory_shouldReturnEmptyCollection_whenNoMatch(){
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.JAZZ);
        assertTrue(0 == items.size());
    }

    @Test
    public void getSelfTitled_shouldReturnCorrectResult() {
        Collection<MusicItem> items = catalog.getSelfTitled();
        assertEquals(2, items.size());
        List<MusicItem> itemList = new ArrayList<>(items);
        assertTrue(6 == itemList.get(0).getId());
        assertTrue(7 == itemList.get(1).getId());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getAll_shouldReturnReadOnlyCollection() {
        Collection<MusicItem> items = catalog.getAll();
        items.clear();
    }

    @Test
    public void getPricedLessThanOrEqualTo_shouldReturnAllItems_LessThanOrEqualToPrice(){
        List<MusicItem> itemList = new ArrayList<>(catalog.getPricedLessThanOrEqualTo(15.));
        //Should be 10 items
        assertTrue(10 == itemList.size());
        //Should all be < $15.00
        for(var item : itemList){
            assertTrue(item.getPrice() < 15.);
        }
    }

    @Test
    public void genreCount_shouldReturnCorrectNumberForEachGenre(){
        Map<MusicCategory, Integer> genreMap = new HashMap<>();
        genreMap.put(MusicCategory.ALTERNATIVE, 2);
        genreMap.put(MusicCategory.BLUES, 2);
        genreMap.put(MusicCategory.CLASSIC_ROCK, 1);
        genreMap.put(MusicCategory.CLASSICAL, 1);
        genreMap.put(MusicCategory.COUNTRY, 1);
        genreMap.put(MusicCategory.JAZZ, 0);
        genreMap.put(MusicCategory.POP, 4);
        genreMap.put(MusicCategory.RAP, 1);
        genreMap.put(MusicCategory.ROCK, 6);

        MusicCategory[] genres = MusicCategory.values();
        for(var genre : genres){
            assertTrue(genreMap.get(genre).equals(catalog.genreCount(genre)));
        }
    }

    @Test
    public void averagePrice_shouldReturnCorrectValue(){
        assertEquals(15.31, catalog.averagePrice(), .0001);
    }

    @Test
    public void cheapestInGenre_shouldReturnCheapestSongInGenre(){
        Collection<MusicItem> items = catalog.cheapestInGenre(MusicCategory.ROCK);
        assertEquals(2, items.size());
        for (var item : items){
            assertEquals(11.97, item.getPrice(), .0001);
        }
    }

    @Test
    public void avgPriceOfGenre_shouldReturnCorrectValue_forGivenGenre(){
        Map<MusicCategory, Double> genreMap = new HashMap<>();
        genreMap.put(MusicCategory.ALTERNATIVE, 16.48);
        genreMap.put(MusicCategory.BLUES, 16.48);
        genreMap.put(MusicCategory.CLASSIC_ROCK, 11.97);
        genreMap.put(MusicCategory.CLASSICAL, 9.97);
        genreMap.put(MusicCategory.COUNTRY, 11.97);
        genreMap.put(MusicCategory.JAZZ, 0.);
        genreMap.put(MusicCategory.POP, 16.23);
        genreMap.put(MusicCategory.RAP, 16.97);
        genreMap.put(MusicCategory.ROCK, 15.64);

        MusicCategory[] genres = MusicCategory.values();
        for(var genre : genres){
            assertTrue(genreMap.get(genre) == (catalog.avgPriceOfGenre(genre)));
        }
    }

    @Test
    public void allTenOrMore_shouldReturnFalse(){
        assertFalse(catalog.allTenOrMore());
    }

    @Test
    public void sellItemInGenre_shouldReturnTrue_whenItemInGenreExists() {
        assertTrue(catalog.sellItemInGenre(MusicCategory.ROCK));
    }

    @Test
    public void sellItemInGenre_shouldReturnFalse_whenNoItemInGenre() {
        assertFalse(catalog.sellItemInGenre(MusicCategory.JAZZ));
    }

    @Test
    public void popTitles_shouldReturnListOfPopTitlesInNaturalOrder() {
        Collection<String> popTitles = catalog.popTitles();
        assertEquals(4, popTitles.size());
        String[] titles = {"Diva", "Dream of the Blue Turtles", "Seal", "So"};
        int index = 0;
        for(var item : popTitles){
            assertEquals(titles[index], item);
            index++;
        }
    }
}