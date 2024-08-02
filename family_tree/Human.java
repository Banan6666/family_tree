package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

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

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public String getFormattedDetails() {
        return "Name: " + name +
                ", Gender: " + gender +
                ", Birth Date: " + birthDate +
                ", Death Date: " + (deathDate != null ? deathDate : "N/A");
    }

    @Override
    public String toString() {
        return "Human{name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                '}';
    }
}