package pointage;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode

public class Travailleur {
    private final String id;
    private final String nom;
    private final String prenom;
    private final String email;
    private final LocalDate dateCreation;
    private final List<LocalDate> pointages = new ArrayList<>();

    public Travailleur(String id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateCreation = LocalDate.now();
    }

    public Travailleur(String id, String nom, String prenom, String email, List<LocalDate> datesPointages) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateCreation = LocalDate.now();
        this.pointages.addAll(datesPointages);
    }

    public long avoirNombreTotalDeJoursEntreDeuxDates(LocalDate dateDebut, LocalDate dateFin) {
        if (dateDebut.isAfter(dateFin)) {
            throw new IllegalArgumentException("La date de début doit être antérieure à la date de fin.");
        }

        return dateFin.toEpochDay() - dateDebut.toEpochDay() - 1;
    }
}
