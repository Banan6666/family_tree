package family_tree.model;

import java.time.LocalDate;

public class Human extends FamilyMember {
    private Gender gender;

    public Human(String name, Gender gender, LocalDate birthDate) {
        super(name, birthDate);
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s | Gender: %-6s | Birth Date: %-10s | Death Date: %-10s",
                getName(),
                gender,
                getBirthDate(),
                getDeathDate() != null ? getDeathDate() : "N/A");
    }
}
