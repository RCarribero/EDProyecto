

public class datosTrabajo {
    private direccion direccionEmpresa;//EMP-8888
    private String correoEmpresa;//x@x.x
    private String numeroEmpresa;//666666666
    private String numeroEmpleado;//666666666
    private String correoEmpleado;//x@x.x
    //CONSTRUCTOR VACIO
    datosTrabajo() {
    }
    //CONSTRUCTOR LLENO
    datosTrabajo(String correoEmpresa, String numeroEmpresa, String numeroEmpleado,
            String correoEmpleado) {
        setCorreoEmpresa(correoEmpresa);
        setNumeroEmpresa(numeroEmpresa);
        setNumeroEmpleado(numeroEmpleado);
        setCorreoEmpleado(correoEmpleado);
    }

    direccion getDireccionEmpresa() {
        return direccionEmpresa;
    }
    void setDireccionEmpresa(direccion direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
        //VALIDACION EN SU CLASE
    }
    String getCorreoEmpresa() {
        return correoEmpresa;
    }
    void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
        if(correoEmpresa.matches("^[a-zA-Z0-9]{3,20}@[a-zA-Z]{1,10}.[a-z]{3}$")){
        }else{
            throw new IllegalArgumentException(" ❌ Formato del correo de la empresa incorrecto, debe de ser (ejemplo@dominio.es)");
        }
    }
    String getNumeroEmpresa() {
        return numeroEmpresa;
    }
    void setNumeroEmpresa(String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
        if(numeroEmpresa.matches("^\\d{9}$")){
        }else{
            throw new IllegalArgumentException(" ❌ Formato del Numero del empleado incorrecto, debe ser(666666666)");
        }
    }
    String getNumeroEmpleado() {
        return numeroEmpleado;
    }
    void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
        if(numeroEmpleado.matches("^\\d{9}$")){
        }else{
            throw new IllegalArgumentException(" ❌ Formato del Numero del empleado incorrecto, debe ser(666666666)");
        }
    }
    String getCorreoEmpleado() {
        return correoEmpleado;
    }
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
