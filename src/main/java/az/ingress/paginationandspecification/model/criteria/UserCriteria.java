package az.ingress.paginationandspecification.model.criteria;

import lombok.*;

/**
 * @author caci
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCriteria {
    private Integer ageFrom;
    private Integer ageTo;
    private String birthPlace;
}
