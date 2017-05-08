package v4.mvp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 *
 * @author weigend
 */
public class IntervalPresenter implements Initializable {
    
    @FXML
    private TextField tfValue;
    @FXML
    private ProgressBar pgValue;
    @FXML
    private Button btUp;
    @FXML
    private Button btDown;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IntervalModel model = new IntervalModel();
        
        pgValue.progressProperty().bind(model.valueProperty().divide(10d));
        tfValue.textProperty().bind(model.valueProperty().asString());
            
        btUp.setOnAction((e) -> {
            model.increase();
        });
        btDown.setOnAction((e) -> {
            model.decrease();
        });
        btDown.disableProperty().bind(model.getAtStart());

    }    
}
