package de.fhrosenheim.gui.customer.search.core;

import de.fhrosenheim.gui.customer.search.api.CustomerDto;
import de.fhrosenheim.gui.customer.search.api.CustomerSearch;
import java.util.Arrays;
import java.util.List;

/**
 * Einfache Mock-Implementierung für die Kundensuche
 * 
 * @author dominik.haas
 */
public class CustomerSearchMock implements CustomerSearch {

    @Override
    public List<CustomerDto> search(String text) {
        return Arrays.asList(
                new CustomerDto("1", "Dominik", "Haas"),
                new CustomerDto("2", "John", "Doe"),
                new CustomerDto("2", "Max", "Mustermann"));
    }
    
}
