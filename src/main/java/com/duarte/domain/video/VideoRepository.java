package com.duarte.domain.video;
import com.duarte.domain.student.Student;

import java.util.List;

public interface VideoRepository {
    void add(Video video);
    List<Video> videosFor(Student student);
}
