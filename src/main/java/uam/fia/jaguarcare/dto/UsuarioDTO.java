package uam.fia.jaguarcare.dto;

import lombok.Data;

import java.util.List;
@Data
public class UsuarioDTO {
    private String cif;
    private String nombre;
    private String contraseña;
    private String rol;
}
