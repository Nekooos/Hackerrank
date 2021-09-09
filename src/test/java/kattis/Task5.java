package kattis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {

    @Test
    public void task5() {

        List<Integer> grades = new ArrayList<>(Arrays.asList(100, 95, 90, 80, 70, 60, 50));
        String studentsAboveAverage = aboveAverage(grades);
        Assertions.assertEquals("57.143%", studentsAboveAverage);
    }

    private String aboveAverage(List<Integer> grades) {
        int numberOfStudents = grades.size();
        int sum = sumGrades(grades);
        double average = sum / numberOfStudents;
        double numberOfStudentsAboveAverage = (double)studentsAboveAverage(average, grades);
        return studentsAboveAverageInPercentage(numberOfStudentsAboveAverage, numberOfStudents);
    }

    private int sumGrades(List<Integer> grades) {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private long studentsAboveAverage(final double average, List<Integer> grades) {
        return grades.stream()
                .filter(grade -> grade >= average)
                .count();
    }

    private String studentsAboveAverageInPercentage(double numberOfStudentsAboveAverage, int numberOfStudents) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        String rounded = decimalFormat.format(numberOfStudentsAboveAverage / numberOfStudents);
        double percentage = Double.parseDouble(rounded) * 100;
        return String.valueOf(percentage).concat("%");
    }
}
