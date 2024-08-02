package family_tree;

import java.io.IOException;
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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the person to view their children: ");
        String name = scanner.nextLine();

        Human person = familyTree.getMembers().stream()
                .filter(h -> h.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (person != null) {
            List<Human> children = familyTree.getChildren(person);
            System.out.println(name + "'s children:");
            for (Human child : children) {
                System.out.println(" - " + child.getFormattedDetails());
            }
        } else {
            System.out.println("Person not found in the family tree.");
        }

        FileOperations fileOperations = new FamilyTreeFileHandler();
        String fileName = "family_tree.ser";

        try {
            fileOperations.writeToFile(fileName, familyTree);
            System.out.println("Family tree has been written to file.");

            FamilyTree loadedFamilyTree = fileOperations.readFromFile(fileName);
            System.out.println("Family tree has been read from file.");
            System.out.println("Family members:");
            for (Human member : loadedFamilyTree.getMembers()) {
                System.out.println(member.getFormattedDetails());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}