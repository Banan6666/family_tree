package family_tree.service;

import family_tree.model.Human;
import family_tree.persistence.FileOperations;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeService {
    private List<Human> familyTree;
    private final FileOperations fileHandler;

    public FamilyTreeService(FileOperations fileHandler) {
        this.fileHandler = fileHandler;
        this.familyTree = new ArrayList<>(); // Инициализация пустого списка, чтобы избежать NullPointerException
    }

    public List<Human> getAllMembers() {
        return familyTree;
    }

    public Human findMemberByName(String name) {
        for (Human member : familyTree) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public void saveFamilyTree() {
        fileHandler.saveToFile("family_tree.dat", familyTree);
    }

    public void loadFamilyTree() {
        familyTree = fileHandler.readFromFile("family_tree.dat");
        if (familyTree == null) {
            familyTree = new ArrayList<>(); // Восстановление пустого списка, если загрузка не удалась
        }
    }
}
