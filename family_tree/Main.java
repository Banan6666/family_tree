package family_tree;

import family_tree.model.FamilyTree;
import family_tree.model.Gender;
import family_tree.model.Human;
import family_tree.persistence.FamilyTreeFileHandler;
import family_tree.persistence.FileOperations;
import family_tree.service.FamilyTreeService;
import family_tree.view.ConsoleView;
import family_tree.view.TreeView;
import family_tree.presenter.TreePresenter;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        familyTree.addMember(new Human("John", Gender.MALE, "1980-05-15", null));
        familyTree.addMember(new Human("Jane", Gender.FEMALE, "1982-08-20", null));
        familyTree.addMember(new Human("Child1", Gender.MALE, "2005-01-10", null));
        familyTree.addMember(new Human("Child2", Gender.FEMALE, "2008-03-25", null));

        FileOperations fileOps = new FamilyTreeFileHandler();
        FamilyTreeService service = new FamilyTreeService(familyTree, fileOps);
        TreeView view = new ConsoleView();
        TreePresenter presenter = new TreePresenter(view, service);

        presenter.run();
    }
}
