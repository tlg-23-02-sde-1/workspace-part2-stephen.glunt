package com.duckrace;

import com.duckrace.Reward;

import java.util.List;

import static com.duckrace.Reward.*;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer d = new DuckRacer(1, "Steve");
        System.out.println(d);
        d.win(DEBIT_CARD);
        List<Reward> rewards = d.getRewards();
        System.out.println(rewards);
        d.win(PRIZES);
        d.win(DEBIT_CARD);
        d.win(PRIZES);
        d.setName("mike");
        System.out.println(d);
        System.out.println(rewards);


    }
}