import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.stream.IntStream;

public class task53 {
    // https://www.hackerrank.com/challenges/s10-binomial-distribution-1/problem
    @Test
    public void task53() {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        Assertions.assertEquals(0.696, Double.parseDouble(decimalFormat.format(binomialDistribution(1.09, 1))));

    }

    private double binomialDistribution(double ratio, int outcome) {
        double p = (ratio)/(ratio+outcome); // 1.09/1
        double q = 1-p; // 1-p
        /*for(int i = 6; i >= 3; i--) {
            result += combination(i) * Math.pow(p, i) * Math.pow(q, 6-i);
        }*/
        return IntStream.range(3,7)
                .mapToDouble(i -> combination(i) * Math.pow(p, i) * Math.pow(q, 6-i))
                .sum();

    }

    private double factorial(int number) {
        return IntStream.rangeClosed(1, number).reduce(1, (i, num) -> i * num);
    }

    private double combination(int i) {
        return (factorial(6)/(factorial(i) * factorial(6-i)));
    }
}
