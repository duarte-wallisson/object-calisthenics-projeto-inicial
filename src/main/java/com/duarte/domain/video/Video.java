package com.duarte.domain.video;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video {

    public static final int PUBLIC = 1;
    public static final int PRIVATE = 2;

    private boolean visibility = false;
    private int ageLimit;

    public void publish(){
        this.visibility = true;
    }

    public boolean isPublic(){
        return this.visibility;
    }

//    public void checkIfVisibilityIsValidAndUpdateIt(int visibility) {
//        if (visibility != PUBLIC && visibility != PRIVATE) {
//            throw new IllegalArgumentException("Invalid visibility");
//        }
//        this.visibility = visibility;
//    }
}
