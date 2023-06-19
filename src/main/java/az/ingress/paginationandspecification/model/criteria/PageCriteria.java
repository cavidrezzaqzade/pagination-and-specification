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
public class PageCriteria {
    private Integer page;
    private Integer count;
}
