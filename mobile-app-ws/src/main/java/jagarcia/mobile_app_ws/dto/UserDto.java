package jagarcia.mobile_app_ws.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @Schema(
            description = "User first name"
    )
    //Validaciones  - user firstname should not be null or empty
    @NotEmpty(message = "user firstname should not be null or empty")
    private String firstName;
    @Schema(
            description = "User last name"
    )
    //- user lastname should not be null or empty
    @NotEmpty(message = "user lastname should not be null or empty")
    private String lastName;
    @Schema(
            description = "User email address"
    )
    //- user email should not be null or empty
    //email address should be valid
    @NotEmpty(message = "user email should not be null or empty")
    @Email(message = "email address should be valid")
    private String email;

}
