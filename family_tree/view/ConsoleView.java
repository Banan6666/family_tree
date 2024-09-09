package family_tree.view;

import java.util.Scanner;

public class ConsoleView implements TreeView {
    private final Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayOptions() {
        System.out.println("1. View Family Tree");
        System.out.println("2. View Member Details");
        System.out.println("3. Save Family Tree");
        System.out.println("4. Load Family Tree");
        System.out.println("Type 'exit' to exit");
        System.out.print("Choose an option: ");
    }

    @Override
    public void displayFamilyTree(String familyTree) {
        System.out.println(familyTree);
    }

    @Override
    public void promptForMemberName() {
        System.out.print("Enter the name of the person: ");
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
