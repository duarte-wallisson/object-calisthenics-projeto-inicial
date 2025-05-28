package com.duarte.domain.video;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video {

    public static final int PUBLIC = 1;
    public static final int PRIVATE = 2;

    private int visibility = PRIVATE;
    private int ageLimit;

    public void checkIfVisibilityIsValidAndUpdateIt(int visibility) {
        if (visibility == PUBLIC || visibility == PRIVATE) {
            this.visibility = visibility;
        } else {
            throw new IllegalArgumentException("Invalid visibility");
        }
    }
}
