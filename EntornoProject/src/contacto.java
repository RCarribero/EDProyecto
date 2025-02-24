import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class contacto {

    private String nombreContacto;
    private String alias;
    private String numTelefono;
    private String correoElectronico;
    private LocalDate fechasImportantes;
    private direccion direccion;
    private datosTrabajo datosTrabajo;
    private static List<String> telefonoList =new ArrayList<>();
    
    public contacto(String nombreContacto, String alias, String numTelefono, String correoElectronico, LocalDate fechasImportantes, datosTrabajo datosTrabajo, direccion direccion) {
        setNombreContacto(nombreContacto);
        setAlias(alias);
        setNumTelefono(numTelefono);
        setCorreoElectronico(correoElectronico);
        setFechasImportantes(fechasImportantes);
        setDireccion(direccion);
        setDatosTrabajo(datosTrabajo);
    }
    public datosTrabajo getDatosTrabajo() {
        return datosTrabajo;
    }
    public void setDatosTrabajo(datosTrabajo datosTrabajo) {
        this.datosTrabajo = datosTrabajo;
    }
    public direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(direccion direccion) {
        this.direccion = direccion;
    }
    public String getNombreContacto() {
        return nombreContacto;
    }
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        if(alias.matches("^{3,50}$")){
            this.alias = alias;
        }else{
            throw new IllegalArgumentException("has puesto un alias con menos de 3 letras");
        }
    }
    public String getNumTelefono() {
        return numTelefono;
    }
    public void setNumTelefono(String numTelefono) {
        boolean verificacion=false;
        if(telefonoList.contains(numTelefono)){
            verificacion=true;
        }else{
            throw new IllegalArgumentException("EL numero de telefono ya esta en uso");
        }
        if(numTelefono.matches("^[0-9]{9}")&&!verificacion){
            this.numTelefono = numTelefono;
        }else{
            throw new IllegalArgumentException("has puesto un numero de telefono no valido, tiene que tener 9 caracteres");
        }
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public LocalDate getFechasImportantes() {
        return fechasImportantes;
    }

    public void setFechasImportantes(LocalDate fechasImportantes) {
        this.fechasImportantes = fechasImportantes;
    }    
}
