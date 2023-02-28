package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {

        Television tvA = new Television(null, 50);
        Television tvB = new Television(null, 50);
        System.out.println(tvA.equals(tvB));

//        Set<Television> tvs = new HashSet<>();
//        tvs.add(tvA);
//        tvs.add(tvB);
//        System.out.println("The size of the set is " + tvs.size());

        Television tvC = new Television("Samasung", 47);
        Television tvD = new Television("LG", 52);

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        System.out.println("The size of the Set is: " + tvs.size());
        for(var tv : tvs){
            System.out.println(tv);
        }
    }
}