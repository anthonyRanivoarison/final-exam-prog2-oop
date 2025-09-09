package pointage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointageTest {
    private Pointage pointage1;
    private Pointage pointage2;
    private Pointage pointage3;
    private Pointage pointage4;
    private Pointage pointage5;

    @BeforeEach
    void setUp() {
        pointage1 = new Pointage(
                LocalDate.of(2025, 9, 10),
                TypeTravail.ENSEIGNEMENT,
                List.of(0.25, 0.25, 0.5),
                "Cours de SYS2"
        );
        pointage2 = new Pointage(
                LocalDate.of(2025, 12, 31),
                TypeTravail.ADMINISTRATION,
                List.of(0.25, 0.25, 0.75),
                "Assistance HEI Admin"
        );
        pointage3 = new Pointage(
                LocalDate.of(2025, 9, 9),
                TypeTravail.ENSEIGNEMENT,
                List.of(0.25, 0.25, 0.5),
                "Cours de WEB2"
        );
        pointage4 = new Pointage(
                LocalDate.of(2025, 12, 31),
                TypeTravail.ADMINISTRATION,
                List.of(0.1, 0.25, 0.3),
                "Assistance HEI Admin"
        );
        pointage5 = new Pointage(
                LocalDate.of(2025, 12, 31),
                TypeTravail.ADMINISTRATION,
                List.of(1.5, 0.25, 0.3),
                "Assistance HEI Admin"
        );
    }

    @Test
    void verifierPointageSucces() {
        assertTrue(pointage1.verifierPointage(LocalDate.of(2025, 9, 10)));
        assertTrue(pointage3.verifierPointage(LocalDate.of(2025, 9, 10)));
    }

    @Test
    void verifierPointageEchoue() {
        assertFalse(pointage2.verifierPointage(LocalDate.of(2025, 9, 10)));
        assertFalse(pointage4.verifierPointage(LocalDate.of(2025, 9, 10)));
    }

    @Test
    void verifierPointageException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pointage5.verifierPointage(LocalDate.of(2025, 9, 10));
        });
        String expectedMessage = "Le quota horaire doit être compris entre 0 (exclus) et 1 (inclus).";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}