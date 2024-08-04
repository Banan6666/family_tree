package family_tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private static final long serialVersionUID = 1L;

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

    public void sortByName() {
        members.sort(Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        members.sort(Comparator.comparing(Human::getBirthDate));
    }

    @Override
    public Iterator<Human> iterator() {
        return members.iterator();
    }
}
