import org.junit.jupiter.api.Test;

public class task53 {
    // https://www.hackerrank.com/challenges/s10-binomial-distribution-1/problem
    @Test
    public void task53() {
        System.out.println(binomialDistribution(1.09, 2)); //0.696
    }

    private double binomialDistribution(double ratio, int outcome) {
        double prohability = ratio / outcome;

        return prohability;
    }
}
