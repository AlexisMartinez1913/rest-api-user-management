package jagarcia.mobile_app_ws.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    //Validaciones  - user firstname should not be null or empty
    @NotEmpty(message = "user firstname should not be null or empty")
    private String firstName;
    //- user lastname should not be null or empty
    @NotEmpty(message = "user lastname should not be null or empty")
    private String lastName;
    //- user email should not be null or empty
    //email address should be valid
    @NotEmpty(message = "user email should not be null or empty")
    @Email(message = "email address should be valid")
    private String email;

}
