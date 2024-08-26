package family_tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Human member) {
        this.members.add(member);
    }

    public List<Human> getMembers() {
        return members;
    }

    public Human getMemberByName(String name) {
        return members.stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
