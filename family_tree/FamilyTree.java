package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L; // Это важно для обеспечения совместимости версий сериализации.

    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Human human) {
        members.add(human);
    }

    public List<Human> getChildren(Human parent) {
        return parent.getChildren();
    }

    public List<Human> getMembers() {
        return members;
    }

    public Human getMemberByName(String name) {
        for (Human member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }
}
