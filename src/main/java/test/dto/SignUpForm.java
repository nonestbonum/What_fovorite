package test.dto;


import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.*;
import test.validators.FIOValidation;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {
    @Size(min = 3, max = 50)
    @Column(name = "fio")
    @FIOValidation
    private String FIO;

    @NotBlank
    private String birthday;

    @Column(unique = true)
    @Email // проверка на ввод почты
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
