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
    
    @Override
    public String toString() {
        return "contacto [nombreContacto=" + nombreContacto + ", alias=" + alias + ", numTelefono=" + numTelefono
                + ", correoElectronico=" + correoElectronico + ", fechasImportantes=" + fechasImportantes
                + ", direccion=" + direccion + ", datosTrabajo=" + datosTrabajo + "]";
    }
    contacto(String nombreContacto, String alias, String numTelefono, String correoElectronico, LocalDate fechasImportantes, datosTrabajo datosTrabajo, direccion direccion) {
        setNombreContacto(nombreContacto);
        setAlias(alias);
        setNumTelefono(numTelefono);
        setCorreoElectronico(correoElectronico);
        setFechasImportantes(fechasImportantes);
        setDireccion(direccion);
        setDatosTrabajo(datosTrabajo);
    }

    
    public contacto() {
    }
    datosTrabajo getDatosTrabajo() {
        return datosTrabajo;
    }
    void setDatosTrabajo(datosTrabajo datosTrabajo) {
        this.datosTrabajo = datosTrabajo;
    }
    direccion getDireccion() {
        return direccion;
    }
    void setDireccion(direccion direccion) {
        this.direccion = direccion;
    }
    String getNombreContacto() {
        return nombreContacto;
    }
    void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    String getAlias() {
        return alias;
    }
    void setAlias(String alias) {
        if(alias.matches("^[A-Za-z]{3,50}$")){
            this.alias = alias;
        }else{
            throw new IllegalArgumentException("has puesto un alias con menos de 3 letras");
        }
    }
    String getNumTelefono() {
        return numTelefono;
    }
    void setNumTelefono(String numTelefono) {
        boolean verificacion=false;
        for (String e : telefonoList) {
            if(e.equalsIgnoreCase(numTelefono)){
                verificacion=true;
            }
        }
        if(numTelefono.matches("^\\d{9}")&&!verificacion){
            this.numTelefono = numTelefono;
            telefonoList.add(numTelefono);
        }else{
            throw new IllegalArgumentException("has puesto un numero de telefono no valido, tiene que tener 9 caracteres");
        }
    }
    String getCorreoElectronico() {
        return correoElectronico;
    }
    void setCorreoElectronico(String correoElectronico) {
        if(correoElectronico.matches("^[A-Za-z0-9]{3,50}@[A-Za-z]{3,50}.[A-Za-z]{3,50}")){
            this.correoElectronico = correoElectronico;
        }else{
            throw new IllegalArgumentException("El correo electronico esta mal");
        }
        
    }
    LocalDate getFechasImportantes() {
        return fechasImportantes;
    }

    void setFechasImportantes(LocalDate fechasImportantes) {
        this.fechasImportantes = fechasImportantes;
    }    
}
