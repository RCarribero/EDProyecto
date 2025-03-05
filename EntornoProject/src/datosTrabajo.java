/**
 * Clase que representa los datos de trabajo de un contacto
 */
public class datosTrabajo {
    private direccion direccionEmpresa;//EMP-8888
    private String correoEmpresa;//x@x.x
    private String numeroEmpresa;//666666666
    private String numeroEmpleado;//666666666
    private String correoEmpleado;//x@x.x
    
    /**
     * Constructor vacío
     */
    datosTrabajo() {
    }
    
    /**
     * Constructor con parámetros
     * @param correoEmpresa correo de la empresa (formato: ejemplo@dominio.es)
     * @param numeroEmpresa número de teléfono de la empresa (9 dígitos)
     * @param numeroEmpleado número de empleado (9 dígitos)
     * @param correoEmpleado correo del empleado (formato: ejemplo@dominio.es)
     */
    datosTrabajo(String correoEmpresa, String numeroEmpresa, String numeroEmpleado,
            String correoEmpleado) {
        setCorreoEmpresa(correoEmpresa);
        setNumeroEmpresa(numeroEmpresa);
        setNumeroEmpleado(numeroEmpleado);
        setCorreoEmpleado(correoEmpleado);
    }

    /**
     * Obtiene la dirección de la empresa
     * @return dirección de la empresa
     */
    direccion getDireccionEmpresa() {
        return direccionEmpresa;
    }
    
    /**
     * Establece la dirección de la empresa
     * @param direccionEmpresa dirección de la empresa
     */
    void setDireccionEmpresa(direccion direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
        //VALIDACION EN SU CLASE
    }
    
    /**
     * Obtiene el correo de la empresa
     * @return correo de la empresa
     */
    String getCorreoEmpresa() {
        return correoEmpresa;
    }
    
    /**
     * Establece el correo de la empresa
     * @param correoEmpresa correo de la empresa (formato: ejemplo@dominio.es)
     */
    void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
        if(correoEmpresa.matches("^[a-zA-Z0-9]{3,20}@[a-zA-Z]{1,10}.[a-z]{3}$")){
        }else{
            throw new IllegalArgumentException(" ❌ Formato del correo de la empresa incorrecto, debe de ser (ejemplo@dominio.es)");
        }
    }
    
    /**
     * Obtiene el número de teléfono de la empresa
     * @return número de teléfono de la empresa
     */
    String getNumeroEmpresa() {
        return numeroEmpresa;
    }
    
    /**
     * Establece el número de teléfono de la empresa
     * @param numeroEmpresa número de teléfono de la empresa (9 dígitos)
     */
    void setNumeroEmpresa(String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
        if(numeroEmpresa.matches("^\\d{9}$")){
        }else{
            throw new IllegalArgumentException(" ❌ Formato del Numero del empleado incorrecto, debe ser(666666666)");
        }
    }
    
    /**
     * Obtiene el número de empleado
     * @return número de empleado
     */
    String getNumeroEmpleado() {
        return numeroEmpleado;
    }
    
    /**
     * Establece el número de empleado
     * @param numeroEmpleado número de empleado (9 dígitos)
     */
    void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
        if(numeroEmpleado.matches("^\\d{9}$")){
        }else{
            throw new IllegalArgumentException(" ❌ Formato del Numero del empleado incorrecto, debe ser(666666666)");
        }
    }
    
    /**
     * Obtiene el correo del empleado
     * @return correo del empleado
     */
    String getCorreoEmpleado() {
        return correoEmpleado;
    }
    
    /**
     * Establece el correo del empleado
     * @param correoEmpleado correo del empleado (formato: ejemplo@dominio.es)
     */
    void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
        //MAL
        if(correoEmpleado.matches("^[a-zA-Z0-9]{3,20}@[a-zA-Z]{1,10}.[a-z]{3}$")){
        }else{
            throw new IllegalArgumentException(" ❌ Formato del correo de la empresa incorrecto, debe de ser (ejemplo@dominio.es)");
        }
    }
    
    @Override
    public String toString() {
        return "datosTrabajo [direccionEmpresa=" + direccionEmpresa + ", correoEmpresa=" + correoEmpresa
                + ", numeroEmpresa=" + numeroEmpresa + ", numeroEmpleado=" + numeroEmpleado + ", correoEmpleado="
                + correoEmpleado + "]";
    }
}
