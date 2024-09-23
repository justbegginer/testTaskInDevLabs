import org.example.Main;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestFindingMissingNumber {

    @ParameterizedTest
    @MethodSource("provideArraysForMissingNumber")
    void findMissingNumber(int[] input, int expected) {
        assertEquals(expected, Main.findMissingNumber(input));
    }

    @ParameterizedTest
    @MethodSource("provideIncorrectArraysForMissingNumber")
    void findMissingNumberWithEmptyArray(int[] input, String expectedMessage) {
        assertThrows(IllegalArgumentException.class, ()-> Main.findMissingNumber(input), expectedMessage);
    }

    private static Stream<Arguments> provideArraysForMissingNumber() {
        return Stream.of(
                Arguments.of(new int[] {5, 0, 1, 3, 2}, 4),
                Arguments.of(new int[] {7, 9, 10, 11, 12}, 8),
                Arguments.of(new int[] {0, 1, 3}, 2)
        );
    }

    private static Stream<Arguments> provideIncorrectArraysForMissingNumber() {
        return Stream.of(
                Arguments.of(new int[] {}, "Input array is empty."),
                Arguments.of(new int[] {1}, "There is only one number. It is impossible to determine the missing number.")
        );
    }
}
