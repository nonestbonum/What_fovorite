package test.dto;

import lombok.*;
import test.validators.HexValidation;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormDto {
    @NotBlank
    private String favDish;
    @NotBlank
    @HexValidation
    private String favColor;
    @NotBlank
    private String favSong;
    @NotBlank
    private String favDate;
    private int favNum;
}
