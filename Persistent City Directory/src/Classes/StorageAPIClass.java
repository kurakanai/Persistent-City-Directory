package Classes;

import Interfaces.StorageAPI;

import java.io.*;

public class StorageAPIClass implements StorageAPI {
    @Override
    public void saveObject(Serializable itemToSave) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(saveLocation));
            objectOutputStream.writeObject(itemToSave);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T loadObjectFromDisk() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveLocation))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
