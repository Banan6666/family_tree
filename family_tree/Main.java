package family_tree;

import family_tree.model.Gender;
import family_tree.model.Human;
import family_tree.persistence.FamilyTreeFileHandler;
import family_tree.service.FamilyTreeService;
import family_tree.view.ConsoleView;
import family_tree.presenter.TreePresenter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        FamilyTreeFileHandler fileHandler = new FamilyTreeFileHandler();
        FamilyTreeService service = new FamilyTreeService(fileHandler);

        Human john = new Human("John", Gender.MALE, LocalDate.of(1980, 5, 15));
        Human jane = new Human("Jane", Gender.FEMALE, LocalDate.of(1982, 8, 20));
        Human child1 = new Human("Child1", Gender.MALE, LocalDate.of(2005, 1, 10));
        Human child2 = new Human("Child2", Gender.FEMALE, LocalDate.of(2008, 3, 25));

        service.getAllMembers().add(john);
        service.getAllMembers().add(jane);
        service.getAllMembers().add(child1);
        service.getAllMembers().add(child2);

        TreePresenter presenter = new TreePresenter(view, service);
        presenter.run();
    }
}
