package Other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DoorsProblem {
    /*
    Imagine that there are 1,000 closed doors in a long corridor.  You must open and close the doors according to a certain pattern.
    Start by opening all the doors.  Then you close every other door, starting with door 2.
    Then you change the position of every third door starting with door 3, ie.
    you close open doors and open closed doors of those affected.
    Then the position changes every fourth door, every fifth door, etc.
    Finally, you open or close door 1,000. Some doors will then be open and others will be closed.

    1. Door 1 you have only changed position at one time.  Is there any other door you only touched once?

    2. Which doors will be open after all openings and closings have been completed?  Explain!

    3. Which doors have you changed position on exactly twice, ie.  opened once and then closed to never touch again?

    4. Will door 1,000 be open or closed?

    5. Which door have you changed position the most times?
     */

    List<Integer> doorsOpened = new ArrayList<>();
    @Test
    public void doorTest() {

        List<Boolean> doors =  IntStream.range(1, 1001)
                .mapToObj(this::openOrClosed)
                .collect(Collectors.toList());

        for(int i = 1; i < doors.size()+1; i++) {
            System.out.println(i + ". " + doors.get(i-1) + " " + (doorsOpened.get(i-1)+1));
        }
    }

    public boolean openOrClosed(int currrentDoor) {
        int openOrClosed = IntStream.range(2, currrentDoor + 1)
                .map((i) -> currrentDoor % i == 0 ? 1 : 0)
                .sum();
        doorsOpened.add(openOrClosed);
        return openOrClosed % 2 == 0;
    }
}




