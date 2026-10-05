package Interfaces;

import java.io.Serializable;

public interface StorageAPI {
    /// The location where the database will be saved. For this project, the location will always be the same.
    String saveLocation = "CitySave.ser";

    /// Method for saving a serializable object's state.
    ///
    /// @param itemToSave Serializable object to be stored in saveLocation.
    void saveObject(Serializable itemToSave);

    /// Method for loading an object from disk.
    ///
    /// @param <T> The type of object that will be loaded from disk.
    /// @return The unserialized object of the specified type <T>.
    <T> T loadObjectFromDisk();
}
