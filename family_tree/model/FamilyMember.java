package family_tree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class FamilyMember implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<FamilyMember> parents;
    private List<FamilyMember> children;

    public FamilyMember(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
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

    public List<FamilyMember> getParents() {
        return parents;
    }

    public void addParent(FamilyMember parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public List<FamilyMember> getChildren() {
        return children;
    }

    public void addChild(FamilyMember child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s | Birth Date: %-10s | Death Date: %-10s",
                name,
                birthDate,
                deathDate != null ? deathDate : "N/A");
    }
}
