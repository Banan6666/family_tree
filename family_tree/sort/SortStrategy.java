package family_tree.sort;

import family_tree.model.Human;

import java.util.List;

public interface SortStrategy {
    List<Human> sort(List<Human> members);
}
