package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television>{
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

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        }

        else if (o != null && this.getClass() == o.getClass()) {
            Television that = (Television) o;
            result = this.getVolume() == that.getVolume() &&
                    Objects.equals(this.getBrand(), that.getBrand());
        }
        return result;
    }

    @Override
    public int hashCode() {
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

    /**
     * Natural order is defined by 'brand' (String) and then volume (int) when tied on brand.
     * Since brand (String) is already Comparable, just delegate to its compareTo() method.
     * @param other
     * @return
     */
    @Override
    public int compareTo(Television other) {
        int result;
        if (this.getBrand() == null && other.getBrand() == null) {
            result = 0;
        } else if (this.getBrand() == null) {
            result = -1;
        } else if (other.getBrand() == null) {
            result = 1;
        } else {
            result = this.getBrand().compareTo(other.getBrand());
        }

        if(result == 0){
            //result = Integer.compare(this.getVolume(), other.getVolume());
            result = this.getVolume() - other.getVolume();
        }
        return result;
    }


}