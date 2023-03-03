/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest_old {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {

//         testFindById();
//         testFindByKeyword();
//         testFindByCategory();
//         testSize();
//         testGetAll();
//         testGetSelfTitled();
//         testGetPricedLessThanOrEqualTo();
//         testGenreCount();
        testAveragePrice();
//        testCheapestInCategory();
//        testAveragePriceInGegre();
//        TestAllTenOrMore();
//        testsellItemInGenre();
//        testpopTitles();
//        testeightysMusicLessThan();
        testgenreMap();
    }

    private static void testgenreMap() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        for(var item : catalog.genreMap().entrySet()){
            System.out.println(item);
        }
//        System.out.println(catalog.genreMap().entrySet());
    }

    private static void testeightysMusicLessThan() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        for(var item : catalog.eightysMusicLessThan(20.0)){
            System.out.println(item);
        }
    }

    private static void testpopTitles() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        for(var item : catalog.popTitles()){
            System.out.println(item);
        }
    }

    private static void testsellItemInGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        for(MusicCategory genre : MusicCategory.values()){
            System.out.println(genre);
            System.out.println("We sell " + genre + " music: " + catalog.sellItemInGenre(genre));
            System.out.println();
        }
    }

    private static void TestAllTenOrMore() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.allTenOrMore());
    }

    private static void testAveragePriceInGegre() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.printf("\n\nTesting cheapestInCategory\n\n");
        //Test each of the categories
        for(MusicCategory genre : MusicCategory.values()){
            System.out.println(genre);
            System.out.println("Average price in " + genre + " is " + catalog.avgPriceOfGenre(genre));
            System.out.println();
        }
    }

    private static void testCheapestInCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.printf("\n\nTesting cheapestInCategory\n\n");
        //Test each of the categories
        for(MusicCategory genre : MusicCategory.values()){
            System.out.println(genre);
            System.out.println("cheapest in " + genre + " is " + catalog.cheapestInGenre(genre));
            System.out.println();
        }
    }

    private static void testAveragePrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println("Average price is: " + catalog.averagePrice());
    }

    private static void testGenreCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println("COUNTRY count is: " + catalog.genreCount(MusicCategory.ROCK));
    }

    private static void testGetPricedLessThanOrEqualTo() {
        System.out.printf("\n\nTesting getPricedLessThanOrEqualTo\n");
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.getPricedLessThanOrEqualTo(14.));
    }

    private static void testGetSelfTitled() {

        System.out.printf("\n\nTesting getSelfTitled\n\n");
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.getSelfTitled());
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        //Test to see if 15 returns "Big Ones"
        System.out.println(catalog.findById(15L));

        //Test if null is returned for invalid id
        System.out.println(catalog.findById(19L));
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.printf("\n\nTesting findByKeyword: \n\n");
        //Test if matches with title and artist work
        dump(catalog.findByKeyword("bobs"));
        dump(catalog.findByKeyword("little"));
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.printf("\n\nTesting findByCategory\n\n");
        //Test each of the categories
        for(MusicCategory genre : MusicCategory.values()){
            System.out.println(genre);
            dump(catalog.findByCategory(genre));
            System.out.println();
        }
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println("18 should equal: " + catalog.size());
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> readOnlyCatalog = catalog.getAll();
        dump(readOnlyCatalog);
    }

    private static void dump (Collection items){
        for(var item : items){
            System.out.println(item);
        }
    }
}