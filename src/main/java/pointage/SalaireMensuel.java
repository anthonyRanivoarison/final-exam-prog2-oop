package pointage;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@ToString
@Generated

public class SalaireMensuel {
    private static List<Promotion> promotions;

    public static void setPromotions(List<Promotion> promotions) {
        SalaireMensuel.promotions = promotions;
    }

    public List<Promotion> avoirListeDesPromotionsEntreDeuxDates(LocalDate dateDebut, LocalDate dateFin) {
        return promotions.stream()
                .filter(promotion ->
                        (promotion.getDateDebut().isAfter(dateDebut) || promotion.getDateDebut().isEqual(dateDebut)) &&
                        (promotion.getDateFin().isBefore(dateFin) || promotion.getDateFin().isEqual(dateFin))
                )
                .toList();
    }
}
