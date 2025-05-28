package com.duarte.domain.video;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoTest {

    @Test
    void changeVisibilityMustWork() {
        Video video = new Video();
        video.checkIfVisibilityIsValidAndUpdateIt(Video.PUBLIC);

        assertEquals(Video.PUBLIC, video.getVisibility());
    }
}
