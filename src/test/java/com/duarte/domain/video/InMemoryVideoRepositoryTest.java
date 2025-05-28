package com.duarte.domain.video;

import com.duarte.domain.student.Student;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InMemoryVideoRepositoryTest {

    @Test
    void findingVideosForAStudentMustFilterAgeLimit() {
        InMemoryVideoRepository repository = new InMemoryVideoRepository();

        // Adiciona vídeos com limites de idade de 21 a 17
        for (int i = 21; i >= 17; i--) {
            Video video = new Video();
            video.setAgeLimit(i);
            repository.add(video);
        }

        // Cria um mock de Student com idade de 19 anos
        Student student = mock(Student.class);
        LocalDate nineteenYearsAgo = LocalDate.now().minusYears(19);
        when(student.getBirthDate()).thenReturn(nineteenYearsAgo);

        List<Video> videoList = repository.videosFor(student);

        // Espera-se que apenas vídeos com limite de idade <= 19 sejam retornados (19, 18, 17)
        assertEquals(3, videoList.size());
    }
}

