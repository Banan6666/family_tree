package family_tree.file;

import family_tree.model.FamilyTree;

public interface FileOperations {
    void writeToFile(FamilyTree familyTree, String filePath);
    FamilyTree readFromFile(String filePath);
}
