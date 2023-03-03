/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.util.*;

// OF COURSE THIS CLASS DOESN'T COMPILE
// Your first job is to fulfill the contract that this class has signed.
public class InMemoryCatalog implements Catalog {

    private List<MusicItem> catalogData = new ArrayList<>(List.of(
                   /* id    title                        artist                       releaseDate  price  musicCategory */
        new MusicItem(1L,  "Diva",                      "Annie Lennox",              "1992-01-04", 13.99, MusicCategory.POP),
        new MusicItem(2L,  "Dream of the Blue Turtles", "Sting",                     "1985-02-05", 14.99, MusicCategory.POP),
        new MusicItem(3L,  "Trouble is...",             "Kenny Wayne Shepherd Band", "1997-08-08", 14.99, MusicCategory.BLUES),
        new MusicItem(4L,  "Lie to Me",                 "Jonny Lang",                "1997-08-26", 17.97, MusicCategory.BLUES),
        new MusicItem(5L,  "Little Earthquakes",        "Tori Amos",                 "1992-01-18", 14.99, MusicCategory.ALTERNATIVE),
        new MusicItem(6L,  "Seal",                      "Seal",                      "1991-08-18", 17.97, MusicCategory.POP),
        new MusicItem(7L,  "Ian Moore",                 "Ian Moore",                 "1993-12-05",  9.97, MusicCategory.CLASSICAL),
        new MusicItem(8L,  "So Much for the Afterglow", "Everclear",                 "1997-01-19", 13.99, MusicCategory.ROCK),
        new MusicItem(9L,  "Surfacing",                 "Sarah McLachlan",           "1997-12-04", 17.97, MusicCategory.ALTERNATIVE),
        new MusicItem(10L, "Hysteria",                  "Def Leppard",               "1987-06-20", 17.97, MusicCategory.ROCK),
        new MusicItem(11L, "A Life of Saturdays",       "Dexter Freebish",           "2000-12-06", 16.97, MusicCategory.RAP),
        new MusicItem(12L, "Human Clay",                "Creed",                     "1999-10-21", 18.97, MusicCategory.ROCK),
        new MusicItem(13L, "My, I'm Large",             "Bobs",                      "1987-02-20", 11.97, MusicCategory.COUNTRY),
        new MusicItem(14L, "So",                        "Peter Gabriel",             "1986-10-03", 17.97, MusicCategory.POP),
        new MusicItem(15L, "Big Ones",                  "Aerosmith",                 "1994-05-08", 18.97, MusicCategory.ROCK),
        new MusicItem(16L, "90125",                     "Yes",                       "1983-10-16", 11.97, MusicCategory.ROCK),
        new MusicItem(17L, "1984",                      "Van Halen",                 "1984-08-19", 11.97, MusicCategory.ROCK),
        new MusicItem(18L, "Escape",                    "Journey",                   "1981-02-25", 11.97, MusicCategory.CLASSIC_ROCK))
    );

    /**
     * Returns the item with the given id, or null if not found.
     */
    public MusicItem findById(Long id){
        MusicItem result = null;
        for(var item : catalogData){
            if(item.getId().equals(id)){
                result = item;
                break;
            }
        }
        return result;
    }



    /**
     * Returns a collection of items that match the supplied keyword.
     * This is basically a search method.
     *
     * A match is defined as any item whose title or artist contains the keyword.
     * Searches are to be case insensitive.
     *
     * A no-matches result should return an empty collection (not null).
     */
    public Collection<MusicItem> findByKeyword(String keyword){
        Collection<MusicItem> result = new ArrayList<>();
        for(var item : catalogData){
            if(item.getArtist().toLowerCase().contains(keyword.toLowerCase()) ||
                    item.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                result.add(item);
            }
        }
        return result;
    }


    /**
     * Returns a collection of items that are of the supplied genre (category).
     */
    public Collection<MusicItem> findByCategory(MusicCategory category){
        Collection<MusicItem> result = new ArrayList<>();
        for(var item : catalogData){
            if(item.getMusicCategory().equals(category)){
                result.add(item);
            }
        }
        return result;
    }


    /**
     * Size of the catalog.
     */
    public int size() {
        return catalogData.size();
    }


    /**
     * Read-only view of the entire catalog.
     * See java.util.Collections class (an all-static utility class) for help here.
     */
    public Collection<MusicItem> getAll() {
        return Collections.unmodifiableList(catalogData);
    }

    /**
     * After you've satisfied your contractual obligations above, do these additional tasks.
     *
     * NOTES:
     * 0. You can tackle them in any order, each one is independent of the others.
     *    They generally get harder as you go further down.
     *
     * 1. None of these methods should print to stdout (the console).  Instead, return a value.
     *    Each one should be tested by a test method in InMemoryCatalogTest,
     *    and there you *can* print your results, to verify that your code works correctly.
     *
     * 2. You may need to research a few things, that's to be expected.  Life Is Open-Book...
     *    The Javadoc is a good first place to look.
     *
     * 3. Keep a lookout for redundant code.  There is a high probability that you will write a chunk
     *    of code more than once.  When you see that, you should strongly consider refactoring that
     *    repeated code into a private method, and then calling that method from where it's needed.
     *    IntelliJ helps a lot here.  Select the repeated code in question, then
     *    right-click -> Refactor -> Extract Method.
     *    It's not just about removing redundancies - it will make the more complicated methods easier to write!
     */

    /**
     * TASK: find all MusicItems where title is same as artist.
     * For example, Madonna's first album is simply titled, "Madonna."
     */
    public Collection<MusicItem> getSelfTitled(){
        Collection<MusicItem> result = new ArrayList<>();
        for(var item : catalogData){
            if(item.getTitle().equalsIgnoreCase(item.getArtist())){
                result.add(item);
            }
        }
        return result;
    }


    /**
     * TASK: find all "rock" items whose price is less than or equal to the specified price.
     */
    public Collection<MusicItem> getPricedLessThanOrEqualTo(Double price){
        Collection<MusicItem> result = new ArrayList<>();
        for(var item : catalogData){
            if(item.getPrice() <= price){
                result.add(item);
            }
        }
        return result;
    }


    /**
     * TASK: how many items of the specified genre (MusicCategory) do we sell?
     */
    public int genreCount(MusicCategory genre){
        int count = 0;
        for(var item : catalogData){
            if(item.getMusicCategory().equals(genre)){
                count++;
            }
        }
        return count;
    }

    /**
     * TASK: determine average price of our low-cost, extensive catalog of music.
     */
    public double averagePrice(){
        double average = 0;
        for(var item : catalogData){
            average += item.getPrice();
        }
        average = average / catalogData.size();
        return Math.round(average * 100.0) / 100.0;
    }


    /**
     * TASK: find the cheapest item with the specified genre (MusicCategory).
     * return as collection
     */
    public Collection<MusicItem> cheapestInGenre(MusicCategory genre){
        double price = 10000000.0;
        Collection<MusicItem> result = new ArrayList<>();
        for(var item : findByCategory(genre)){
            if(item.getPrice() < price){
                price = item.getPrice();
            }
        }
        for(var item : findByCategory(genre)) {
            if(item.getPrice() <= price){
                result.add(item);
            }
        }
        return result;
    }


    /**
     * TASK: find the average price of items in the specified genre (MusicCategory).
     */
    public double avgPriceOfGenre(MusicCategory genre){
        double avg = 0.;
        int count = 0;
        for(var item : findByCategory(genre)){
            avg += item.getPrice();
            count++;
        }
        if(count == 0) return 0.0;
        return avg / count;
    }


    /**
     * TASK: are all items priced at least $10?
     * This is a yes/no answer.
     */
    public boolean allTenOrMore(){
        boolean result = true;
        for(var item : catalogData){
            if (item.getPrice() < 10.0){
                result = false;
            }
        }
        return result;
    }


    /**
     * TASK: do we sell any items with the specified genre (MusicCategory)?
     * Another yes/no answer.
     */
    public boolean sellItemInGenre(MusicCategory genre){
        boolean result = false;
        for(var item : findByCategory(genre)){
            if(item != null){
                result = true;
                break;
            }
        }
        return result;
    }


    /**
     * TASK: find the titles of all "pop" items, sorted by natural order.
     * Just the titles!
     * @return
     */
    public Collection<String> popTitles(){
        TreeSet<String> result = new TreeSet<>();
        for(var item : findByCategory(MusicCategory.POP)){
            result.add(item.getTitle());
        }
        return result;
    }


    /**
     * TASK: find all items released in the 80s whose price is less than or equal to the specified price.
     */
    public Collection<MusicItem> eightysMusicLessThan(double price){
        Collection<MusicItem> result = new ArrayList<>();
        for(var item : getPricedLessThanOrEqualTo(price)){
            if(item.getReleaseDate().toString().startsWith("198")){
                result.add(item);
            }
        }
        return result;
    }


    /**
     * TASK: return a map whose keys are all the genres (categories), and each key's associated value
     * is a collection of items in that genre.  If there is a genre that we don't currently
     * sell, that key's associated value should be an empty collection, not null.
     */
    public Map<MusicCategory,Collection> genreMap (){
        Map<MusicCategory, Collection> result = new HashMap<>();
        for(MusicCategory genre : MusicCategory.values()){
            result.put(genre,findByCategory(genre));
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getClass().getSimpleName() + ": \n");
        for (MusicItem item: catalogData) {
            builder.append(item).append("\n");
        }
        return builder.toString();
    }
}