import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Task8 {
    @Test
    public void task8() {
        int[] ar = {3,2,1,3};
        int highestCandle = Arrays.stream(ar)
                .max()
                .getAsInt();

        int[] remainingCandles = Arrays.stream(ar).
                filter(height -> height == highestCandle)
                .peek(num -> System.out.println(num))
                .toArray();

        int blownOutCandles = remainingCandles.length;
    }
}
