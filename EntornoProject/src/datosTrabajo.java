public class datosTrabajo {
    private direccion direccionEmpresa;
    private String correoEmpresa;
    private String numeroEmpresa;
    private String numeroEmpleado;
    private String correoEmpleado;
    //CONSTRUCTOR VACIO
    datosTrabajo() {
    }
    //CONSTRUCTOR LLENO
    datosTrabajo(direccion direccionEmpresa, String correoEmpresa, String numeroEmpresa, String numeroEmpleado,
            String correoEmpleado) {
        this.direccionEmpresa = direccionEmpresa;
        this.correoEmpresa = correoEmpresa;
        this.numeroEmpresa = numeroEmpresa;
        this.numeroEmpleado = numeroEmpleado;
        this.correoEmpleado = correoEmpleado;
    }
    @Override
    public String toString() {
        return "datosTrabajo [direccionEmpresa=" + direccionEmpresa + ", correoEmpresa=" + correoEmpresa
                + ", numeroEmpresa=" + numeroEmpresa + ", numeroEmpleado=" + numeroEmpleado + ", correoEmpleado="
                + correoEmpleado + "]";
    }
    direccion getDireccionEmpresa() {
        return direccionEmpresa;
    }
    void setDireccionEmpresa(direccion direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }
    String getCorreoEmpresa() {
        return correoEmpresa;
    }
    void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }
    String getNumeroEmpresa() {
        return numeroEmpresa;
    }
    void setNumeroEmpresa(String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }
    String getNumeroEmpleado() {
        return numeroEmpleado;
    }
    void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
    String getCorreoEmpleado() {
        return correoEmpleado;
    }
    void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }
    
}
