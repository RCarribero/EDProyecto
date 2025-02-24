public class datosTrabajo {
    private direccion direccionEmpresa;
    private String correoEmpresa;
    private String numeroEmpresa;
    private String numeroEmpleado;
    private String correoEmpleado;
    //CONSTRUCTOR VACIO
    public datosTrabajo() {
    }
    //CONSTRUCTOR LLENO
    public datosTrabajo(direccion direccionEmpresa, String correoEmpresa, String numeroEmpresa, String numeroEmpleado,
            String correoEmpleado) {
        this.direccionEmpresa = direccionEmpresa;
        this.correoEmpresa = correoEmpresa;
        this.numeroEmpresa = numeroEmpresa;
        this.numeroEmpleado = numeroEmpleado;
        this.correoEmpleado = correoEmpleado;
    }
    public direccion getDireccionEmpresa() {
        return direccionEmpresa;
    }
    public void setDireccionEmpresa(direccion direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }
    public String getCorreoEmpresa() {
        return correoEmpresa;
    }
    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }
    public String getNumeroEmpresa() {
        return numeroEmpresa;
    }
    public void setNumeroEmpresa(String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }
    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }
    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
    public String getCorreoEmpleado() {
        return correoEmpleado;
    }
    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }
    
}
