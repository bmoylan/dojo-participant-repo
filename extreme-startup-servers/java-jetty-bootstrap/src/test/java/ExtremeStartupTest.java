
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup();

    @Test
    public void should_accept_missing_input() {
        assertThat(server.answer(null), equalTo("Don't Care"));
    }

    @Test
    public void should_add_numbers() {
        assertThat(server.answer("what is the sum of 14 and 4"), equalTo("18"));
    }

    @Test
    public void should_plus_numbers() {
        assertThat(server.answer("what is 14 plus 4"), equalTo("18"));
    }

    @Test
    public void largest_numbers() {
        assertThat(server.answer("which of the following numbers is the largest: 29, 92, 123, 24"), equalTo("123"));
    }

    @Test
    public void cubes_and_square() {
        assertThat(server.answer("which of the following numbers is both a square and a cube: 1600, 170, 4, 292"),
                equalTo(""));
    }
}
