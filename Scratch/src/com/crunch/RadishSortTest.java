package com.crunch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();
        radishes.add(new Radish("red", 1.1, 2.1, 1));
        radishes.add(new Radish("pink", 1.1, 2.0, 0));
        radishes.add(new Radish("pink", 3.5, 0.0, 3));
        radishes.add(new Radish("black", 2.2, 4.2, 0));
        radishes.add(new Radish("white", 1.8, 0.6, 7));

        System.out.println("Original list");
        dump(radishes);

        radishes.sort(null);
        System.out.println();
        System.out.println("Sort by natural order:");
        dump(radishes);

        System.out.println();

        // sort by color via an instance of RadishColorComparator
        System.out.println("Sort by color:");
        radishes.sort(new RadishColorComparator());
        dump (radishes);

        System.out.println("Sort by color reversed order");
        radishes.sort(new RadishColorComparator().reversed());
        dump(radishes);

        System.out.println("Sort by tail length");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish o1, Radish o2) {
                return Double.compare(o1.getTailLength(), o2.getTailLength());
            }
        });
        dump(radishes);

        System.out.println("Sort by number of sprouts");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return Integer.compare(r1.getSprouts(), r2.getSprouts());
            }
        });
        dump(radishes);


    }
    private static void dump(List myList){
        for(var el : myList){
            System.out.println(el);
        }
    }
}