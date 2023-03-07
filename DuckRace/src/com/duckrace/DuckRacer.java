package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer {

    //instance variables
    private final int id;
    private String name;
    private final List<Reward> rewards = new ArrayList<>();

    DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    // business methods
    public void win(Reward reward){
        rewards.add(reward);
    }

    //accessor methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return rewards.size();
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public String toFile(){
        return String.format("%s,%s,%s",getId(), getName(), getRewards());
    }

    public String toConsole(){
        return String.format("%2f  %s",getId(),getName());
    }

    @Override
    public String toString() {
        return String.format("%s: id=%s, name=%s, wins=%s, rewards=%s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}