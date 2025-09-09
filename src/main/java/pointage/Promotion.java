package pointage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString

public class Promotion {
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String raison;
}
