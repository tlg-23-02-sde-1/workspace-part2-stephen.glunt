/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import java.util.Arrays;
import java.util.List;
import com.entertainment.Television;
import com.entertainment.TelevisionBrandChannelComparator;
import com.entertainment.TelevisionChannelComparator;

public class TelevisionTestSort {
  
  public static void main(String[] args) {
    // dataset for testing
    List<Television> tvList = createTelevisionList();
    
    // sort by natural order and print
    tvList.sort(null);
    
    System.out.println("Sorted by brand (natural order)");
    dump(tvList);
    System.out.println();
    
     //TODO: uncomment this to test your comparator class
    // sort by supplied Comparator and print
    tvList.sort(new TelevisionChannelComparator());
    
    System.out.println("Sorted by channel");
    dump(tvList);
    System.out.println();

    tvList.sort(new TelevisionBrandChannelComparator());

    System.out.println("Sorted by brand then channel");
    dump(tvList);

  }

  private static void dump(List tvList){
    for (var tv : tvList) {
      System.out.println(tv);
    }
  }
  
  // dataset for testing
  private static List<Television> createTelevisionList() {
    Television tv1 = new Television("Zenith", 30);
    tv1.setCurrentChannel(44);
    
    Television tv2 = new Television("Hitachi", 10);
    tv2.setCurrentChannel(9);
    
    Television tv3 = new Television("Sony", 50);
    tv3.setCurrentChannel(13);
    
    Television tv4 = new Television("RCA", 25);
    
    Television tv5 = new Television("Hitachi", 5);
    
    Television tv6 = new Television("Sony", 40);
    
    return Arrays.asList(tv1, tv2, tv3, tv4, tv5, tv6);
  }
}