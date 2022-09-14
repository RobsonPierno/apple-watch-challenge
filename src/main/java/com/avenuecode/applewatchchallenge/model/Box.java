package com.avenuecode.applewatchchallenge.model;

public class Box {

    private Boolean awarded;

    public Box(final Boolean awarded){
        this.awarded = awarded;
    }

    public Boolean isAwarded(){
        return this.awarded;
    }
}
