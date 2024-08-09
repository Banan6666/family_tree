package family_tree;

import family_tree.model.FamilyTree;

public interface FileOperations<T> {
    void writeToFile(T object, String filePath);
    T readFromFile(String filePath);
}
