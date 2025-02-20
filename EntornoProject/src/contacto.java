import java.time.LocalDate;

public class contacto {

    private String nombreContacto;
    private String alias;
    private String numTelefono;
    private String correoElectronico;
    private String tipoContacto;
    private String infoTrabajo;
    private LocalDate fechasImportantes;
    private String relaciones;//padres,amigos(otros contactos)
    private String notas;
    private String sitioWeb;
    
    public contacto(String nombreContacto, String alias, String numTelefono, String correoElectronico, String tipoContacto,
            String infoTrabajo, LocalDate fechasImportantes, String relaciones, String notas, String sitioWeb) {
        setNombreContacto(nombreContacto);
        setAlias(alias);
        setNumTelefono(numTelefono);
        setCorreoElectronico(correoElectronico);
        setTipoContacto(tipoContacto);
        setInfoTrabajo(infoTrabajo);
        setFechasImportantes(fechasImportantes);
        setRelaciones(relaciones);
        setNotas(notas);
        setSitioWeb(sitioWeb);
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
        if(numTelefono.matches("^[0-9]{9}")){
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

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public String getInfoTrabajo() {
        return infoTrabajo;
    }

    public void setInfoTrabajo(String infoTrabajo) {
        this.infoTrabajo = infoTrabajo;
    }

    public LocalDate getFechasImportantes() {
        return fechasImportantes;
    }

    public void setFechasImportantes(LocalDate fechasImportantes) {
        this.fechasImportantes = fechasImportantes;
    }

    public String getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(String relaciones) {
        this.relaciones = relaciones;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }
    
    
}
