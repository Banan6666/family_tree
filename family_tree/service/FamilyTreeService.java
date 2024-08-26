package family_tree.service;

import family_tree.model.FamilyTree;
import family_tree.model.Human;
import family_tree.persistence.FileOperations;
import family_tree.sort.SortStrategy;
import family_tree.sort.SortByName;

import java.util.List;

public class FamilyTreeService {
    private final FamilyTree familyTree;
    private final FileOperations fileHandler;
    private SortStrategy sortStrategy;

    public FamilyTreeService(FamilyTree familyTree, FileOperations fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
        this.sortStrategy = new SortByName(); // По умолчанию сортировка по имени
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public List<Human> getSortedMembers() {
        return sortStrategy.sort(familyTree.getMembers());
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void saveFamilyTree(String fileName) {
        fileHandler.saveToFile(fileName, familyTree);
    }

    public FamilyTree loadFamilyTree(String fileName) {
        return fileHandler.readFromFile(fileName);
    }
}
