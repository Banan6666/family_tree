package family_tree;

import java.io.IOException;

public interface FileOperations {
    void writeToFile(String fileName, FamilyTree familyTree) throws IOException;
    FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException;
}