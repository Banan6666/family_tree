package family_tree.view;

public interface TreeView {
    void displayOptions();
    void displayFamilyTree(String familyTree);
    void promptForMemberName();
    void displayMemberInfo(String memberInfo);
    void displayMessage(String message);
    String getUserInput();
}
