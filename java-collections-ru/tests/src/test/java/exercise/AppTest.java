package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> actual1 = App.take(Arrays.asList(1, 2, 3, 4, 5), 3);
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(actual1).isEqualTo(expected1);

        List<Integer> actual2 = App.take(Arrays.asList(7, 16, 24, 56), 10);
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(7, 16, 24, 56));
        assertThat(actual2).isEqualTo(expected2);

        List<Integer> actual3 = App.take(Arrays.asList(96, 72, 10), 0);
        List<Integer> expected3 = new ArrayList<>();
        assertThat(actual3).isEqualTo(expected3);
        // END
    }
}
