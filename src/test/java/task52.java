import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class task52 {

    //https://www.hackerrank.com/challenges/s10-standard-deviation/problem

    @Test
    public void task52() {
        System.out.println(standardDeviation(Arrays.asList(10, 40, 30, 50, 20)));
    }

    private double standardDeviation(List<Integer> numbers) {
        Collections.sort(numbers);
        double mean = calculateMean(numbers);
        return calculateStandardDeviation(numbers, mean);

    }

    private double calculateMean(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::intValue) 
                .sum()/numbers.size();
    }

    private double calculateStandardDeviation(List<Integer> numbers, double mean) {
        return Math.sqrt(numbers.stream()
                .mapToDouble(num -> Math.abs(num - mean) * Math.abs(num - mean))
                .sum()/numbers.size());
    }
}
