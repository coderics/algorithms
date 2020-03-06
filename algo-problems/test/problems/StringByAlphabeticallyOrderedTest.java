package problems;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test
public class StringByAlphabeticallyOrderedTest {

    StringByAlphabeticallyOrdered task;

    @BeforeTest
    public void init() {
        task = new StringByAlphabeticallyOrdered();
    }

    public void getLongestOrderedWord() {
        // Given
        List<String> list = Arrays.asList("banana", "at", "apartment", "Daniel", "CSV", "Jeremy", "London", "pqrstu", "abcdefgh");
        // When
        String result = task.retrieveLongest(list);
        // Then
        Assert.assertEquals(result, "abcdefgh");
    }

    public void getShortestOrderedWord() {
        // Given
        List<String> list = Arrays.asList("banana", "at", "apartment", "Daniel", "CSV", "Jeremy", "London", "pqrstu", "abcdefgh");
        // When
        String result = task.retrieveShortest(list);
        // Then
        Assert.assertEquals(result, "at");
    }
}
