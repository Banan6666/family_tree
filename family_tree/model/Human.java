package family_tree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember, Serializable {
    private final String name;
    private final Gender gender;
    private final LocalDate birthDate;
    private LocalDate deathDate;
    private final List<Human> parents;
    private final List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return new ArrayList<>(parents);
    }

    @Override
    public List<Human> getChildren() {
        return new ArrayList<>(children);
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    @Override
    public void addChild(Human child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Gender: %s | Birth Date: %s | Death Date: %s",
                name, gender, birthDate, (deathDate != null ? deathDate : "N/A"));
    }
}
