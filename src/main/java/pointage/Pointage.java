package pointage;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Getter


public class Pointage {
    private LocalDate date;
    private TypeTravail typeTravail;
    private List<Double> quotaHoraires;
    private String description;

    public boolean verifierPointage(LocalDate date) {
        quotaHoraires.forEach(horaire -> {
            if (horaire > 1 || horaire <= 0) {
                throw new IllegalArgumentException("Le quota horaire doit être compris entre 0 (exclus) et 1 (inclus).");
            }
        });
        double total = quotaHoraires.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        return total == 1;
    }
}
