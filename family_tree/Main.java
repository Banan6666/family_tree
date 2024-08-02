package family_tree;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human john = new Human("John", Gender.Male, LocalDate.of(1980, 5, 15));
        Human jane = new Human("Jane", Gender.Female, LocalDate.of(1982, 8, 20));
        Human child1 = new Human("Child1", Gender.Male, LocalDate.of(2005, 1, 10));
        Human child2 = new Human("Child2", Gender.Female, LocalDate.of(2008, 3, 25));

        john.addChild(child1);
        john.addChild(child2);
        jane.addChild(child1);
        jane.addChild(child2);

        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        FileOperations fileOps = new FamilyTreeFileHandler();
        String filePath = "family_tree.dat";

        fileOps.writeToFile(familyTree, filePath);
        System.out.println("Family tree saved to file: " + filePath);

        FamilyTree loadedFamilyTree = fileOps.readFromFile(filePath);
        System.out.println("Family tree loaded from file: " + filePath);

        System.out.println("\n=== Loaded Family Tree ===");
        for (Human member : loadedFamilyTree.getMembers()) {
            System.out.println(member);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the name of the person to view their children: ");
        String name = scanner.nextLine().trim();

        Human selectedMember = loadedFamilyTree.getMemberByName(name);

        if (selectedMember != null) {
            System.out.println("\n--- Information about " + selectedMember.getName() + " ---");
            System.out.println(selectedMember);

            List<Human> children = loadedFamilyTree.getChildren(selectedMember);
            if (children.isEmpty()) {
                System.out.println(selectedMember.getName() + " has no children.");
            } else {
                System.out.println("\n--- Children of " + selectedMember.getName() + " ---");
                for (Human child : children) {
                    System.out.println(child);
                }
            }
        } else {
            System.out.println("\nNo member found with the name '" + name + "'. Please make sure you entered the name correctly.");
        }

        scanner.close();
    }
}
