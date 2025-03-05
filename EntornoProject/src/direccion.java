/**
 * Clase que representa la dirección de un contacto
 */
public class direccion {
private int Numero_puerta;
private String Avenida;
private String Pueblo_Ciudad;

/**
 * Constructor por defecto
 */
public direccion() {
}

/**
 * Constructor con parámetros
 * @param numero_puerta número de la puerta (entre 1 y 99)
 * @param avenida nombre de la avenida
 * @param pueblo_Ciudad nombre del pueblo o ciudad
 */
public direccion(int numero_puerta, String avenida, String pueblo_Ciudad) {
    setNumero_puerta(numero_puerta);
    setAvenida(avenida);
    setPueblo_Ciudad(pueblo_Ciudad);
}

@Override
public String toString() {
    return "direccion [Numero_puerta=" + Numero_puerta + ", Avenida=" + Avenida + ", Pueblo_Ciudad=" + Pueblo_Ciudad
            + "]";
}

/**
 * Obtiene el número de puerta
 * @return número de puerta
 */
int getNumero_puerta() {
    return Numero_puerta;
}

/**
 * Establece el número de puerta
 * @param numero_puerta número de puerta (entre 1 y 99)
 */
void setNumero_puerta(int numero_puerta) {
    if(numero_puerta>0 && numero_puerta<100){
        Numero_puerta = numero_puerta;
    }else{
        throw new IllegalArgumentException(" ❌ El numero de la puerta es mayor que 100");
    }
    
}

/**
 * Obtiene el nombre de la avenida
 * @return nombre de la avenida
 */
String getAvenida() {
    return Avenida;
}

/**
 * Establece el nombre de la avenida
 * @param avenida nombre de la avenida (solo letras, entre 3 y 100 caracteres)
 */
void setAvenida(String avenida) {
    if(avenida.matches("^[A-Za-z\\s]{3,100}$")){
        Avenida = avenida;
    }else{
        throw new IllegalArgumentException(" ❌ la avenida contiene caracteres invalidos");
    }
    
    
}

/**
 * Obtiene el nombre del pueblo o ciudad
 * @return nombre del pueblo o ciudad
 */
String getPueblo_Ciudad() {
    return Pueblo_Ciudad;
}

/**
 * Establece el nombre del pueblo o ciudad
 * @param pueblo_Ciudad nombre del pueblo o ciudad (solo letras, entre 3 y 50 caracteres)
 */
void setPueblo_Ciudad(String pueblo_Ciudad) {
    if(pueblo_Ciudad.matches("^[A-Za-z\\s]{3,50}$")){
        Pueblo_Ciudad = pueblo_Ciudad;
    }else{
        throw new IllegalArgumentException(" ❌ El nombre del pueblo o de la cuidad contiene caracteres que no tiene que contener");
    }
}

}
