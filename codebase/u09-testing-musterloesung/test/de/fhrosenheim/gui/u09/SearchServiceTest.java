package de.fhrosenheim.gui.u09;

import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchServiceTest {

    // SUT = System under test
    private SearchService sut;

    @Before
    public void setUp() {
        sut = new SearchService();
    }

    @Test
    public void search_for_cat() {
        List<String> actual = sut.search("katze");

        assertThat(actual, Matchers.contains("katze1.jpg", "katze2.jpg"));
    }

    @Test
    public void search_for_dog() {
        List<String> actual = sut.search("hund");

        assertThat(actual, Matchers.contains("hund1.jpg", "hund2.jpg"));
    }

    @Test
    public void search_for_snake() {
        List<String> actual = sut.search("schlange");

        assertThat(actual, Matchers.hasSize(0));
    }
}
