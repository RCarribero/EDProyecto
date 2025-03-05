import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un contacto en la agenda
 */
public class contacto {

    private String nombreContacto;
    private String alias;
    private String numTelefono;
    private String correoElectronico;
    private LocalDate fechasImportantes;
    private direccion direccion;
    private datosTrabajo datosTrabajo;
    private static List<String> telefonoList = new ArrayList<>();
    
    @Override
    public String toString() {
        return "contacto [nombreContacto=" + nombreContacto + ", alias=" + alias + ", numTelefono=" + numTelefono
                + ", correoElectronico=" + correoElectronico + ", fechasImportantes=" + fechasImportantes
                + ", direccion=" + direccion + ", datosTrabajo=" + datosTrabajo + "]";
    }
    
    /**
     * Constructor con parámetros
     * @param nombreContacto nombre del contacto
     * @param alias alias del contacto (3-50 letras)
     * @param numTelefono número de teléfono (9 dígitos)
     * @param correoElectronico correo electrónico (formato válido)
     * @param fechasImportantes fechas importantes
     * @param direccion dirección del contacto
     * @param datostrabajo datos de trabajo del contacto
     * @throws IllegalArgumentException si algún parámetro no cumple con el formato requerido
     */
    contacto(String nombreContacto, String alias, String numTelefono, String correoElectronico, LocalDate fechasImportantes, direccion direccion, datosTrabajo datostrabajo ) {
        setNombreContacto(nombreContacto);
        setAlias(alias);
        setCorreoElectronico(correoElectronico);
        setFechasImportantes(fechasImportantes);
        setDireccion(direccion);
        setDatosTrabajo(datosTrabajo);
        setNumTelefono(numTelefono);
    }

    /**
     * Constructor por defecto
     */
    public contacto() {
    }
    
    /**
     * Obtiene los datos de trabajo del contacto
     * @return datos de trabajo
     */
    datosTrabajo getDatosTrabajo() {
        return datosTrabajo;
    }
    
    /**
     * Establece los datos de trabajo del contacto
     * @param datosTrabajo datos de trabajo a establecer
     */
    void setDatosTrabajo(datosTrabajo datosTrabajo) {
        this.datosTrabajo = datosTrabajo;
    }
    
    /**
     * Obtiene la dirección del contacto
     * @return dirección
     */
    direccion getDireccion() {
        return direccion;
    }
    
    /**
     * Establece la dirección del contacto
     * @param direccion dirección a establecer
     */
    void setDireccion(direccion direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Obtiene el nombre del contacto
     * @return nombre del contacto
     */
    String getNombreContacto() {
        return nombreContacto;
    }
    
    /**
     * Establece el nombre del contacto
     * @param nombreContacto nombre a establecer
     */
    void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    
    /**
     * Obtiene el alias del contacto
     * @return alias
     */
    String getAlias() {
        return alias;
    }
    
    /**
     * Establece el alias del contacto
     * @param alias alias a establecer (3-50 letras)
     * @throws IllegalArgumentException si el alias no cumple con el formato requerido
     */
    void setAlias(String alias) {
        if(alias.matches("^[A-Za-z]{3,50}$")){
            this.alias = alias;
        }else{
            throw new IllegalArgumentException(" ❌ has puesto un alias con menos de 3 letras");
        }
    }
    
    /**
     * Obtiene el número de teléfono del contacto
     * @return número de teléfono
     */
    String getNumTelefono() {
        return numTelefono;
    }
    
    /**
     * Establece el número de teléfono del contacto
     * @param numTelefono número de teléfono a establecer (9 dígitos)
     * @throws IllegalArgumentException si el número de teléfono no cumple con el formato requerido o ya está en uso
     */
    void setNumTelefono(String numTelefono) {
        boolean verificacion=true;
        if(telefonoList.contains(numTelefono)){
            throw new IllegalArgumentException("El numero de telefono esta en uso");
        }
        if(numTelefono.matches("^\\d{9}$")){
            this.numTelefono = numTelefono;
            telefonoList.add(numTelefono);
        }else{
            throw new IllegalArgumentException(" ❌ has puesto un numero de telefono no valido, tiene que tener 9 caracteres");
        }
    }
    
    /**
     * Obtiene el correo electrónico del contacto
     * @return correo electrónico
     */
    String getCorreoElectronico() {
        return correoElectronico;
    }
    
    /**
     * Establece el correo electrónico del contacto
     * @param correoElectronico correo electrónico a establecer (formato válido)
     * @throws IllegalArgumentException si el correo electrónico no cumple con el formato requerido
     */
    void setCorreoElectronico(String correoElectronico) {
        if(correoElectronico.matches("^[a-zA-Z0-9]{3,20}@[a-zA-Z]{1,10}.[a-z]{3}$")){
            this.correoElectronico = correoElectronico;
        }else{
            throw new IllegalArgumentException(" ❌ El correo electronico esta mal");
        }
        
    }
    
    /**
     * Obtiene las fechas importantes del contacto
     * @return fechas importantes
     */
    LocalDate getFechasImportantes() {
        return fechasImportantes;
    }

    /**
     * Establece las fechas importantes del contacto
     * @param fechasImportantes fechas importantes a establecer
     */
    void setFechasImportantes(LocalDate fechasImportantes) {
        this.fechasImportantes = fechasImportantes;
    }    
}
