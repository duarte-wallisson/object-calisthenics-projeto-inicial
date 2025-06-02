package com.duarte.domain.student;

import com.duarte.domain.video.Video;
import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String email;
    private LocalDate birthDate;
    private final Map<Video, LocalDate> watchedVideos = new LinkedHashMap<>();
    private String firstName;
    private String lastName;

    public String street;
    public String number;
    public String province;
    public String city;
    public String state;
    public String country;

    public void validateEmail() {
        if (email == null || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid e-mail address");
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void watch(Video video, LocalDate date) {
        watchedVideos.put(video, date);
    }

    public boolean hasAccess() {
        if (watchedVideos.isEmpty()) {
            return true;
        }

        return firstVideoWasWatchedInLessThan90Days();
    }

    private boolean firstVideoWasWatchedInLessThan90Days() {
        LocalDate firstDate = watchedVideos.values().stream()
                .min(Comparator.naturalOrder())
                .orElse(LocalDate.now());

        long daysSinceFirst = ChronoUnit.DAYS.between(firstDate, LocalDate.now());
        return daysSinceFirst < 90;
    }
}
