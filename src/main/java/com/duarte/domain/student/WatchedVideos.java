package com.duarte.domain.student;

import com.duarte.domain.video.Video;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;

@AllArgsConstructor
public class WatchedVideos {
    private Map<Video, LocalDate>  videos;

    public void add(Video video, LocalDate date) {
        videos.put(video, date);
    }

    public int count() {
        return videos.size();
    }

    public LocalDate dateOfFirstVideo() {
        return videos.values().stream()
                .min(Comparator.naturalOrder())
                .orElse(LocalDate.now());

    }
}
