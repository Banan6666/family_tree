package family_tree.persistence;

import family_tree.model.FamilyTree;

public interface FileOperations {
    void saveToFile(String fileName, FamilyTree familyTree);
    FamilyTree readFromFile(String fileName);
}
