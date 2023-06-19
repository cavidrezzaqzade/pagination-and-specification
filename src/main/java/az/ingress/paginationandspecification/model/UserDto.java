package az.ingress.paginationandspecification.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author caci
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    //@NotBlank TODO: implement validation
    private String name;

    private Short age;
}
