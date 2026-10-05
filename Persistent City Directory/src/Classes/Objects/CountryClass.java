package Classes.Objects;

import Interfaces.Objects.CountryObject;

public class CountryClass implements CountryObject {
    private String name;
    public CountryClass(String name){
        setName(name);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }
}
