package family_tree.model;

import java.io.Serializable;

public class Human implements Serializable {
    private final String name;
    private final Gender gender;
    private final String birthDate;
    private final String deathDate;

    public Human(String name, Gender gender, String birthDate, String deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDeathDate() {
        return deathDate != null ? deathDate : "N/A";
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s | Gender: %-6s | Birth Date: %-10s | Death Date: %-10s",
                name, gender, birthDate, getDeathDate());
    }
}
