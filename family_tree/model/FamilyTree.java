package family_tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;

    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getChildren(T parent) {
        List<T> children = new ArrayList<>();
        for (FamilyMember child : parent.getChildren()) {
            children.add((T) child);
        }
        return children;
    }

    public List<T> getMembers() {
        return members;
    }

    public T getMemberByName(String name) {
        for (T member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        members.sort((m1, m2) -> m1.getName().compareToIgnoreCase(m2.getName()));
    }

    public void sortByBirthDate() {
        members.sort((m1, m2) -> m1.getBirthDate().compareTo(m2.getBirthDate()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Family Tree:\n");
        for (T member : members) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }
}
