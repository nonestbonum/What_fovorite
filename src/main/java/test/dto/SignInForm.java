package test.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInForm {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
