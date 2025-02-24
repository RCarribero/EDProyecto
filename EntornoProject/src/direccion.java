public class direccion {
private int Numero_puerta;
private String Avenida;
private String Pueblo_Ciudad;
public direccion() {
}
public direccion(int numero_puerta, String avenida, String pueblo_Ciudad) {
    setNumero_puerta(numero_puerta);
    setAvenida(avenida);
    setPueblo_Ciudad(pueblo_Ciudad);
}
int getNumero_puerta() {
    return Numero_puerta;
}
void setNumero_puerta(int numero_puerta) {
    if(numero_puerta>0 && numero_puerta<100){
        Numero_puerta = numero_puerta;
    }else{
        throw new IllegalArgumentException("El numero de la puerta es mayor que 100");
    }
    
}
String getAvenida() {
    return Avenida;
}
void setAvenida(String avenida) {
    if(avenida.matches("^\\[A-Za-z]{3,100}$")){
        Avenida = avenida;
    }else{
        throw new IllegalArgumentException("la avenida contiene caracteres invalidos");
    }
    
    
}
String getPueblo_Ciudad() {
    return Pueblo_Ciudad;
}
void setPueblo_Ciudad(String pueblo_Ciudad) {
    if(pueblo_Ciudad.matches("^\\[A-Za-z]")){
        Pueblo_Ciudad = pueblo_Ciudad;
    }else{
        throw new IllegalArgumentException("El nombre del pueblo o de la cuidad contiene caracteres que no tiene que contener");
    }
}

}
