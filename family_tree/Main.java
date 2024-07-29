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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the person to find their children:");
        String name = scanner.nextLine();

        Human person = familyTree.findMemberByName(name);
        if (person != null) {
            List<Human> children = familyTree.getChildren(person);
            if (!children.isEmpty()) {
                System.out.println(person.getName() + "'s children:");
                for (Human child : children) {
                    System.out.println(child.getName());
                }
            } else {
                System.out.println(person.getName() + " has no children.");
            }
        } else {
            System.out.println("Person not found in the family tree.");
        }
    }
}