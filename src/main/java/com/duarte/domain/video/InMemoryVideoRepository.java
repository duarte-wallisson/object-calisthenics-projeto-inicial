package com.duarte.domain.video;
import com.duarte.domain.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryVideoRepository implements VideoRepository {

    private final List<Video> videos = new ArrayList<>();

    @Override
    public void add(Video video) {
        videos.add(video);
    }

    @Override
    public List<Video> videosFor(Student student) {
        return videos.stream()
                .filter(video -> video.getAgeLimit() <= student.getAge())
                .collect(Collectors.toList());
    }
}

