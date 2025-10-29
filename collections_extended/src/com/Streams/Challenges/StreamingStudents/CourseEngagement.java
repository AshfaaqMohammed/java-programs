package com.Streams.Challenges.StreamingStudents;

import java.time.LocalDate;
import java.time.Period;

public class CourseEngagement {
    private final Course course;
    private final LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType) {
        this.course = course;
        this.enrollmentDate = this.lastActivityDate = enrollmentDate;
        this.engagementType = engagementType;
    }

    public String getCourseCode() {
        return course.courseCode();
    }

    public int getEnrollmentYear() {
        return enrollmentDate.getYear();
    }

    public String getEngagementType() {
        return engagementType;
    }

    public int getLastLecture() {
        return lastLecture;
    }

    public int getLastActivityYear() {
        return lastActivityDate.getYear();
    }
    public String getLastActivityMonth(){
        return "%tb".formatted(lastActivityDate);
    }
    public double getPercentComplete(){
        return lastLecture * 100.0 / course.lectureCount();
    }

    public int getMonthsSinceActive(){
        LocalDate now = LocalDate.now();
        Period p = Period.between(lastActivityDate,now);
        var years = p.getYears();
        var months = p.getMonths();
        return (years * 12) + months;
    }

    void watchLecture(int lectureNumber, LocalDate currentDate){
        lastLecture = Math.max(lectureNumber,lastLecture);
        lastActivityDate = currentDate;
        engagementType = "Lecture " + lastLecture;
    }

    @Override
    public String toString(){
        return "%s: %s %d %s [%d]".formatted(course.courseCode(),
                getLastActivityMonth(), getLastActivityYear(), engagementType, getMonthsSinceActive());
    }
}
