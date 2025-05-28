package com.duarte.domain.student;

import com.duarte.domain.video.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student(
                "email@example.com",
                LocalDate.of(1997, 10, 15),
                "Vinicius",
                "Dias",
                "Rua de Exemplo",
                "71B",
                "Meu Bairro",
                "Minha Cidade",
                "Meu estado",
                "Brasil"
        );
    }

    @Test
    void studentWithoutWatchedVideosHasAccess() {
        assertTrue(student.hasAccess());
    }

    @Test
    void studentWithFirstWatchedVideoInLessThan90DaysHasAccess() {
        LocalDate date = LocalDate.now().minusDays(89);
        student.watch(new Video(), date);

        assertTrue(student.hasAccess());
    }

    @Test
    void studentWithFirstWatchedVideoInLessThan90DaysButOtherVideosWatchedHasAccess() {
        student.watch(new Video(), LocalDate.now().minusDays(89));
        student.watch(new Video(), LocalDate.now().minusDays(60));
        student.watch(new Video(), LocalDate.now().minusDays(30));

        assertTrue(student.hasAccess());
    }

    @Test
    void studentWithFirstWatchedVideoIn90DaysDoesNotHaveAccess() {
        student.watch(new Video(), LocalDate.now().minusDays(90));

        assertFalse(student.hasAccess());
    }

    @Test
    void studentWithFirstWatchedVideoIn90DaysButOtherVideosWatchedDoesNotHaveAccess() {
        student.watch(new Video(), LocalDate.now().minusDays(90));
        student.watch(new Video(), LocalDate.now().minusDays(60));
        student.watch(new Video(), LocalDate.now().minusDays(30));

        assertFalse(student.hasAccess());
    }
}

