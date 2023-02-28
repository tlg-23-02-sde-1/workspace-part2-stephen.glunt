package com.entertainment;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class TelevisionMultiComparator implements Comparator<Television> {
    TelevisionMultiComparator(Object ...args){

    }

    @Override
    public int compare(Television o1, Television o2) {
        return 0;
    }

    @Override
    public Comparator<Television> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Television> thenComparing(Comparator<? super Television> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Television> thenComparing(Function<? super Television, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Television> thenComparing(Function<? super Television, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Television> thenComparingInt(ToIntFunction<? super Television> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Television> thenComparingLong(ToLongFunction<? super Television> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Television> thenComparingDouble(ToDoubleFunction<? super Television> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}