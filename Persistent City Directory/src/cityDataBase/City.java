package cityDataBase;

import java.io.Serializable;

public interface City extends Serializable {
    String getName();
    String getCountry();
    int getPopulation();
}
