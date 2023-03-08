package com.crunch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTestLambda {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();
        radishes.add(new Radish("red", 1.1, 2.1, 1));
        radishes.add(new Radish("pink", 1.1, 2.0, 0));
        radishes.add(new Radish("pink", 3.5, 0.0, 3));
        radishes.add(new Radish("black", 2.2, 4.2, 0));
        radishes.add(new Radish("white", 1.8, 0.6, 7));

        System.out.println("Original list");
        dump(radishes);



        System.out.println();

        System.out.println("Sort by tail length via Lambda: ");
        radishes.sort((a,b) -> Double.compare(a.getTailLength(), b.getTailLength()));
        dump(radishes);

        System.out.println("Sort by number of sprouts: ");
        radishes.sort((a,b) -> Integer.compare(a.getSprouts(), b.getSprouts()));
        dump(radishes);

        System.out.println("Sort by size:");
        radishes.sort((a,b) -> Double.compare(a.getSize(),b.getSize()));
        dump(radishes);




    }
    private static void dump(List myList){
        for(var el : myList){
            System.out.println(el);
        }
    }
}