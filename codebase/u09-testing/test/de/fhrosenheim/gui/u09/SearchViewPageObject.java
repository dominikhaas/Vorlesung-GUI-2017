package de.fhrosenheim.gui.u09;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.loadui.testfx.GuiTest;

public class SearchViewPageObject {

    private final GuiTest guiTest;

    public SearchViewPageObject(GuiTest guiTest) {
        this.guiTest = guiTest;
    }

    public Button getSearchButton() {
        return (Button) guiTest.find("#search");
    }
    
    public TextField getQueryTextField() {
        return (TextField) guiTest.find("#query");
    }

    public SearchViewPageObject query(String query) {
        getQueryTextField().setText(query);
        return this;
    }

    public SearchViewPageObject search() {
        guiTest.click(getSearchButton());
        return this;
    }
}
