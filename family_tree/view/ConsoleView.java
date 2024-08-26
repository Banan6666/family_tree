package family_tree.view;

import java.util.Scanner;

public class ConsoleView implements TreeView {
    private final Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayFamilyTree(String familyTree) {
        System.out.println(familyTree);
    }

    @Override
    public void promptForMemberName() {
        System.out.print("Enter the name of the person to view their details: ");
    }

    @Override
    public void displayMemberInfo(String memberInfo) {
        System.out.println(memberInfo);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine().trim();
    }
}
