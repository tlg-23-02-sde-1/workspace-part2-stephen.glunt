package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {
    public static void main(String[] args) {

        Television tvA = new Television(null, 50);
        Television tvB = new Television(null, 50);
        System.out.println(tvA.equals(tvB));

        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        System.out.println("The size of the set is " + tvs.size());
    }
}