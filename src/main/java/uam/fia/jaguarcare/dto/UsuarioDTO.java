package uam.fia.jaguarcare.dto;

import lombok.Data;
import uam.fia.jaguarcare.model.Rol;

import java.util.List;
@Data
public class UsuarioDTO {
    private String cif;
    private String nombre;
    private String contraseña;
    private Rol rol;
}
