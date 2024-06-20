package uam.fia.jaguarcare.dto;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
@Data
public class UsuarioDTO {
    private String idRecepcionista;

    String Cedula;

    String name;

    String password;
}
