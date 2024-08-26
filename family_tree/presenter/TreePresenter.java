package family_tree.presenter;

import family_tree.model.Human;
import family_tree.service.FamilyTreeService;
import family_tree.view.TreeView;

import java.util.List;

public class TreePresenter {
    private final TreeView view;
    private final FamilyTreeService service;

    public TreePresenter(TreeView view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        while (true) {
            view.displayFamilyTree(getFormattedFamilyTree());
            view.promptForMemberName();

            String name = view.getUserInput();
            if (name.equalsIgnoreCase("exit")) {
                view.displayMessage("Exiting...");
                break;
            }

            Human member = service.getFamilyTree().getMemberByName(name);
            if (member != null) {
                view.displayMemberInfo(getFormattedMemberDetails(member));
            } else {
                view.displayMessage("No member found with the name '" + name + "'.");
            }
        }
    }

    private String getFormattedFamilyTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Family Tree ===\n");
        List<Human> members = service.getSortedMembers();
        for (Human member : members) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }

    private String getFormattedMemberDetails(Human member) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Member Details ===\n");
        sb.append(member).append("\n");
        return sb.toString();
    }
}
