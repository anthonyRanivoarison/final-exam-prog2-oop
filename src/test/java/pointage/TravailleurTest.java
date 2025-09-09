package pointage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravailleurTest {

    private Travailleur john;

    @BeforeEach
    void setUp() {
        var pointage1 = new Pointage(
                LocalDate.of(2025, 9, 10),
                TypeTravail.ENSEIGNEMENT,
                List.of(0.25, 0.25, 0.5),
                "Cours de SYS2"
        );
        var pointage2 = new Pointage(
                LocalDate.of(2025, 12, 31),
                TypeTravail.ADMINISTRATION,
                List.of(0.25, 0.25, 0.75),
                "Assistance HEI Admin"
        );
        var pointage3 = new Pointage(
                LocalDate.of(2025, 9, 9),
                TypeTravail.ENSEIGNEMENT,
                List.of(0.25, 0.25, 0.5),
                "Cours de WEB2"
        );
        john = new Travailleur(
                "1",
                "Doe",
                "John",
                "johndoe@gmail.com",
                List.of(pointage1.getDate(), pointage2.getDate(), pointage3.getDate())
        );
    }

    @Test
    void avoirNombreTotalDeJoursEntreDeuxDates() {
        LocalDate dateDebut = LocalDate.of(2025, 9, 10);
        LocalDate dateFin = LocalDate.of(2025, 9, 20);
        long attendu = john.avoirNombreTotalDeJoursEntreDeuxDates(dateDebut, dateFin);
        assertEquals(9, attendu);
    }
}