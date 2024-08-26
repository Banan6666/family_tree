package family_tree.sort;

import family_tree.model.Human;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByBirthDate implements SortStrategy {
    @Override
    public List<Human> sort(List<Human> members) {
        return members.stream()
                .sorted(Comparator.comparing(Human::getBirthDate))
                .collect(Collectors.toList());
    }
}
