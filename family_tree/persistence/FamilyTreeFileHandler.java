package family_tree.persistence;

import family_tree.model.FamilyTree;

import java.io.*;

public class FamilyTreeFileHandler implements FileOperations {
    @Override
    public void saveToFile(String fileName, FamilyTree familyTree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
