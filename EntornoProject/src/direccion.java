public class direccion {
private int Numero_puerta;
private String Avenida;
private String Pueblo_Ciudad;
public direccion() {
}
public direccion(int numero_puerta, String avenida, String pueblo_Ciudad) {
    Numero_puerta = numero_puerta;
    Avenida = avenida;
    Pueblo_Ciudad = pueblo_Ciudad;
}
public int getNumero_puerta() {
    return Numero_puerta;
}
public void setNumero_puerta(int numero_puerta) {
    if(numero_puerta>0 && numero_puerta<100){
        Numero_puerta = numero_puerta;
    }else{
        throw new IllegalArgumentException("El numero de la puerta es mayor que 100");
    }
    
}
public String getAvenida() {
    return Avenida;
}
public void setAvenida(String avenida) {
    Avenida = avenida;
}
public String getPueblo_Ciudad() {
    return Pueblo_Ciudad;
}
public void setPueblo_Ciudad(String pueblo_Ciudad) {
    Pueblo_Ciudad = pueblo_Ciudad;
}

}
