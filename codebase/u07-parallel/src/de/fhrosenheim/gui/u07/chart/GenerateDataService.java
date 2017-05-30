package de.fhrosenheim.gui.u07.chart;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart;

/**
 * JavaFX Service der als Factory für den GenerateDataTask fungiert.
 * Diese Klasse kann im Programm einmal am Anfang initialisiert werden und dann
 * dauerhaft verwendet (im Gegensatz zu einem einzelnen Task).
 * 
 * @author dominik.haas
 */
public class GenerateDataService extends Service<ObservableList<XYChart.Series<Number, Number>>> {

    private final StringProperty seriesName = new SimpleStringProperty();
    
    public StringProperty seriesNameProperty() {
        return seriesName;
    }

    @Override
    protected Task<ObservableList<XYChart.Series<Number, Number>>> createTask() {
        return new GenerateDataTask(seriesName.get());
    }
}
