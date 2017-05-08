package v4.mvp;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author dominik.haas
 */
public class IntervalModel {
    private final IntegerProperty value = new SimpleIntegerProperty(2);
    private final BooleanBinding atStart;

    public IntervalModel() {
        atStart = value.lessThanOrEqualTo(0d);
    }

    public int getValue() {
        return value.get();
    }

    public void setValue(int value) {
        this.value.set(value);
    }
    
    public IntegerProperty valueProperty() {
        return value;
    }

    void increase() {
        value.set(value.get() + 1);
    }

    void decrease() {
        value.set(value.get() - 1);
    }

    public BooleanBinding getAtStart() {
        return atStart;
    }
    
    
    
}
