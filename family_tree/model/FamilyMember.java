package family_tree.model;
import java.util.List;

public interface FamilyMember {
    String getName();
    void addParent(Human parent);
    void addChild(Human child);
    List<Human> getChildren();
}
