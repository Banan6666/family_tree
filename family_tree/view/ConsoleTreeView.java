package family_tree.view;

import family_tree.model.FamilyMember;
import java.util.List;

public class ConsoleTreeView<T extends FamilyMember> implements TreeView<T> {

    @Override
    public void showFamilyTree(List<T> members) {
        System.out.println("=== Family Tree ===");
        for (T member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void showMemberDetails(T member) {
        System.out.println("=== Member Details ===");
        System.out.println(member);
    }

    @Override
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
