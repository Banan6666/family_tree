package family_tree.presenter;

import family_tree.model.FamilyTree;
import family_tree.model.FamilyMember;
import family_tree.view.TreeView;
import java.util.List;

public class TreePresenter<T extends FamilyMember> {
    private final FamilyTree<T> familyTree;
    private final TreeView<T> view;

    public TreePresenter(FamilyTree<T> familyTree, TreeView<T> view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void loadFamilyTree() {
        List<T> members = familyTree.getMembers();
        if (members.isEmpty()) {
            view.showError("Family tree is empty.");
        } else {
            view.showFamilyTree(members);
        }
    }

    public void showMemberDetails(String name) {
        T member = familyTree.getMemberByName(name);
        if (member != null) {
            view.showMemberDetails(member);
        } else {
            view.showError("Member not found.");
        }
    }
}
