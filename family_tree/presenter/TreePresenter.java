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
            view.displayOptions();
            String option = view.getUserInput();
            switch (option.toLowerCase()) {
                case "1":
                    view.displayFamilyTree(getFormattedFamilyTree());
                    break;
                case "2":
                    view.promptForMemberName();
                    String name = view.getUserInput();
                    Human member = service.findMemberByName(name);
                    if (member != null) {
                        view.displayMemberInfo(getFormattedMemberDetails(member));
                    } else {
                        view.displayMessage("No member found with the name '" + name + "'.");
                    }
                    break;
                case "3":
                    service.saveFamilyTree();
                    view.displayMessage("Family tree saved successfully.");
                    break;
                case "4":
                    service.loadFamilyTree();
                    view.displayMessage("Family tree loaded successfully.");
                    break;
                case "exit":
                    view.displayMessage("Exiting...");
                    return;
                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private String getFormattedFamilyTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Family Tree ===\n");
        List<Human> members = service.getAllMembers();
        for (Human member : members) {
            sb.append(member.getName()).append("\n");
        }
        return sb.toString();
    }

    private String getFormattedMemberDetails(Human member) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Member Details ===\n");
        sb.append("Name: ").append(member.getName()).append("\n");
        // Добавьте больше информации по необходимости
        return sb.toString();
    }
}
