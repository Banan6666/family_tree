package family_tree;

import java.io.Serializable;

public interface FileOperations {
    void writeToFile(FamilyTree familyTree, String filePath);
    FamilyTree readFromFile(String filePath);
}