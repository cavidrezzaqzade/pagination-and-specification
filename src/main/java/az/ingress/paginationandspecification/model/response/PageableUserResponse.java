package az.ingress.paginationandspecification.model.response;

import az.ingress.paginationandspecification.model.UserDto;
import lombok.*;
import java.util.List;

/**
 * @author caci
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageableUserResponse {
    private List<UserDto> users;
    private int lastPageNumber;
    private long totalElements;
    private boolean hasNextPage;
}