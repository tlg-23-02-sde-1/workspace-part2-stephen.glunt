package com.crunch;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class RadishColorComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish o1, Radish o2) {
        return o1.getColour().compareTo(o2.getColour());
    }

    @Override
    public Comparator<Radish> reversed() {
        return Comparator.super.reversed();
    }
//
//    @Override
//    public Comparator<Radish> thenComparing(Comparator<? super Radish> other) {
//        return Comparator.super.thenComparing(other);
//    }
//
//    @Override
//    public <U> Comparator<Radish> thenComparing(Function<? super Radish, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
//        return Comparator.super.thenComparing(keyExtractor, keyComparator);
//    }
//
//    @Override
//    public <U extends Comparable<? super U>> Comparator<Radish> thenComparing(Function<? super Radish, ? extends U> keyExtractor) {
//        return Comparator.super.thenComparing(keyExtractor);
//    }
//
//    @Override
//    public Comparator<Radish> thenComparingInt(ToIntFunction<? super Radish> keyExtractor) {
//        return Comparator.super.thenComparingInt(keyExtractor);
//    }
//
//    @Override
//    public Comparator<Radish> thenComparingLong(ToLongFunction<? super Radish> keyExtractor) {
//        return Comparator.super.thenComparingLong(keyExtractor);
//    }
//
//    @Override
//    public Comparator<Radish> thenComparingDouble(ToDoubleFunction<? super Radish> keyExtractor) {
//        return Comparator.super.thenComparingDouble(keyExtractor);
//    }
}