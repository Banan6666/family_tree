package family_tree;

import family_tree.model.*;
import family_tree.presenter.TreePresenter;
import family_tree.view.ConsoleTreeView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();

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

        ConsoleTreeView<Human> view = new ConsoleTreeView<>();
        TreePresenter<Human> presenter = new TreePresenter<>(familyTree, view);

        presenter.loadFamilyTree();

        // Example of showing details of a specific member
        presenter.showMemberDetails("John");
    }
}
