package family_tree.persistence;

import java.util.List;

public interface FileOperations {
    void saveToFile(String filename, List<?> data);
    <T> List<T> readFromFile(String filename);
}
