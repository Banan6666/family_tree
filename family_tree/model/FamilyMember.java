package family_tree.model;

import java.io.Serializable;

public abstract class FamilyMember implements Serializable {
    private String name;

    public FamilyMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void addChild(FamilyMember child);

    public abstract String toString();
}
