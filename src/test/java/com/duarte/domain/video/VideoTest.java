package com.duarte.domain.video;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VideoTest {

    @Test
    void makingAVideoPublicMustWork() {
        Video video = new Video();
        video.publish();

        assertTrue(video.isPublic());
    }
}
