package com.duarte.domain.student;

import com.duarte.domain.email.Email;
import com.duarte.domain.video.Video;
import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Email email;
    private LocalDate birthDate;
    private WatchedVideos watchedVideos;
    private String firstName;
    private String lastName;

    public String street;
    public String number;
    public String province;
    public String city;
    public String state;
    public String country;


    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email.toString();
    }

    public void watch(Video video, LocalDate date) {
        watchedVideos.add(video, date);
    }

    public boolean hasAccess() {
        if (watchedVideos.count() == 0) {
            return true;
        }
        return firstVideoWasWatchedInLessThan90Days();
    }

    private boolean firstVideoWasWatchedInLessThan90Days() {
        var firstDate = this.watchedVideos.dateOfFirstVideo();

        long daysSinceFirst = ChronoUnit.DAYS.between(firstDate, LocalDate.now());
        return daysSinceFirst < 90;
    }
}
