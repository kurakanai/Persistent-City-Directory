package Interfaces;

import java.io.Serializable;

public interface StorageAPI {
    String saveLocation = "CitySave.ser";
    void saveObject(Serializable itemToSave);
    <T> T loadObjectFromDisk();
}
