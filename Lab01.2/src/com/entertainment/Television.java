package com.entertainment;

import java.util.Objects;

public class Television {
    //Static variables
    public static int MAX_VOLUME = 100;
    public static int MIN_VOLUME = 0;
    //instance variables
    private String brand;
    private int volume;
    private Tuner tuner = new Tuner();

    //constructors
    public Television(){

    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    //Accessor Methods
    public int getCurrentChannel(){
        return tuner.getChannel();
    }

    public void setCurrentChannel(int channel){
        tuner.setChannel(channel);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume <= MIN_VOLUME){
            this.volume = MIN_VOLUME;
        } else if (volume >= MAX_VOLUME){
            this.volume = MAX_VOLUME;
        } else {
            this.volume = volume;
        }
    }

    public boolean equals(Television tv){
        return (Objects.equals(getBrand(), tv.getBrand()) && (getVolume() == tv.getVolume()));
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Television){
            result = equals((Television) obj);
        }
        return result;
    }

    public int hashCode(){
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "brand='" + getBrand() + '\'' +
                ", volume=" + getVolume() +
                ", tuner=" + getCurrentChannel() +
                '}';
    }
}