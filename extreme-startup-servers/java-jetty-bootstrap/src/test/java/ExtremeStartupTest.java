
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

    @Test
    public void largest_numbers2() {
        assertThat(server.answer("which of the following numbers is the largest: 29, 92, 3, 24"), equalTo("92"));
    }
    @Test
    public void largest_numbers3() {
        assertThat(server.answer("which of the following numbers is the largest: 29, -92, 3, 24, 5, 7"), equalTo("29"));
    }
    @Test
    public void largest_numbers4() {
        assertThat(server.answer("which of the following numbers is the largest: 29"), equalTo("29"));
    }


    @Test
    public void multiply1() {
        assertThat(server.answer("what is 12 multiplied by 1"), equalTo("12"));
    }

    @Test
    public void multiply2() {
        assertThat(server.answer("what is 12 multiplied by 2"), equalTo("24"));
    }

    @Test
    public void multiply3() {
        assertThat(server.answer("what is 12 multiplied by -1"), equalTo("-12"));
    }

    @Test
    public void prime1() {
        assertThat(server.answer("a1bf7350: which of the following numbers are primes: 5, 11, 10"), equalTo("5, 11"));
    }

    @Test
    public void prime2() {
        assertThat(server.answer("a1bf7350: which of the following numbers are primes: 1, 2, 4"), equalTo("2"));
    }

    @Test
    public void banana() {
        assertThat(server.answer("51132ca0: what colour is a banana"), equalTo("Yellow"));
    }
}
