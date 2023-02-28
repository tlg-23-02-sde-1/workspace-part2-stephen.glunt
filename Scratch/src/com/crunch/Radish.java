package com.crunch;

class Radish implements Comparable<Radish>{
    private String colour;
    private double size;
    private double tailLength;
    private int sprouts;

    public Radish(String colour, double size, double tailLength, int sprouts) {
        setColour(colour);
        setSize(size);
        setTailLength(tailLength);
        setSprouts(sprouts);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getSprouts() {
        return sprouts;
    }

    public void setSprouts(int sprouts) {
        this.sprouts = sprouts;
    }

    @Override
    public String toString() {
        return String.format("%s: color=%s, size=%s, tailLength=%s, sprouts=%s",
                getClass().getSimpleName(), getColour(), getSize(), getTailLength(), getSprouts());
    }

    @Override
    public int compareTo(Radish other) {
        int result;
        result = Double.compare(this.getSize(), other.getSize());
        if(result == 0){
            result = Double.compare(this.getSprouts(), other.getSprouts());
        }
        return result;
    }
}