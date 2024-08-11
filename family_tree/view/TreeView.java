package family_tree.view;

import family_tree.model.FamilyMember;
import java.util.List;

public interface TreeView<T extends FamilyMember> {
    void showFamilyTree(List<T> members);
    void showMemberDetails(T member);
    void showError(String message);
}
