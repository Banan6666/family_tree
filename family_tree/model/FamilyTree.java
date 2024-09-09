package family_tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FamilyTree implements Serializable {
    private final List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>(); // Инициализация пустого списка членов семьи
    }

    public void addMember(Human member) {
        members.add(member);
    }

    public List<Human> getMembers() {
        return new ArrayList<>(members); // Возвращаем копию списка, чтобы избежать изменения оригинала
    }

    public List<Human> getMembersSortedByName() {
        members.sort(Comparator.comparing(Human::getName));
        return new ArrayList<>(members); // Возвращаем отсортированный список
    }

    public List<Human> getMembersSortedByBirthDate() {
        members.sort(Comparator.comparing(Human::getBirthDate));
        return new ArrayList<>(members); // Возвращаем отсортированный список
    }

    public Human getMemberByName(String name) {
        return members.stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null); // Возвращаем первого найденного члена семьи или null, если не найден
    }

    public void clear() {
        members.clear();
    }

    public void addAll(List<Human> newMembers) {
        members.addAll(newMembers);
    }
}
