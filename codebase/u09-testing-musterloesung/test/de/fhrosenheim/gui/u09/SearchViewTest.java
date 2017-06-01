package de.fhrosenheim.gui.u09;

import java.util.Arrays;
import javafx.scene.Parent;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.loadui.testfx.GuiTest;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SearchViewTest extends GuiTest {

    @Mock
    private ISearchService searchService;
    @Mock
    private ISearchResultSink searchResultSink;

    private SearchViewPageObject pageObject;

    @Before
    public void setUp() {
        pageObject = new SearchViewPageObject(this);

        // Wenn nach "hund" gesucht wird, wird [hund.jpg] zurückgegeben
        when(searchService.search("hund")).thenReturn(Arrays.asList("hund.jpg"));
    }

    @Test
    public void button_is_enabled_when_text_is_entered() {
        // Button ist aktiviert wenn das Suchfeld Text enthält
        pageObject.query("dummy");
        assertThat(pageObject.getSearchButton().isDisabled(), is(false));
    }

    @Test
    public void button_is_disabled_when_text_is_empty() {
        // Button ist deaktiviert wenn das Suchfeld leer ist
        pageObject.query("");
        assertThat(pageObject.getSearchButton().isDisabled(), is(true));
    }

    @Test
    public void type_dog() {
        // Wenn wir nach "hund" suchen
        pageObject.query("hund").search();

        // Dann wird die Sink mit [hund.jpg] aufgerufen
        verify(searchResultSink).process(Arrays.asList("hund.jpg"));
    }

    @Override
    protected Parent getRootNode() {
        return new SearchView(searchService, searchResultSink);
    }
}
