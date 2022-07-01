package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
/*
STAGE 2 - User 249379983
Los cinefilos deberian poder verificar la disponibilidad de asientos
antes de comprar un boleto. En esta etapa, debe agregar un punto final
para verificar y comprar un boleto disponible. Si el boleto ha sido comprado
o la solicitud contiene informacion incorrecta sobre el boleto, devuelve
un mensaje de error.
OBJETIVOS
Implementar el punto final /purchase que maneja una solicitud POST y marca
un billete reservado como comprado.
Una solicitud debe tener los siguientes datos.
- row - el numero de fila
- column - el numero de columna
Tome estas variables y verifique si el boleto especificado esta disponible
Si el billete esta reservado, marca el asiento como comprado y no lo muestrs
en la lista.
Si la compra es exitosa, el cuerpo de la respuesta debe ser el siguiente:
{
    "row": 5,
    "column": 7,
    "price": 8
}
El precio del boleto esta determinado por un numero de fila. Si el numero
de fila es menor o igual a 4, establezca el precio en 10. Todas las demas filas
cuestan 8 por asiento.
Si el asiento esta ocupado, responda con un 400 (Bad Request). El cuerpo de
la respuesta debe contener lo siguiente:
{
    "error": "The ticket has been already purchased!"
}
Si los usuarios pasan un numero de fila/columna incorrecto, responda con
un codigo 400 y la siguiente linea.
{
    "error": "The number of a row or a column is out of bounds!"
}
Mostrar el precio del billete cuando se accede al punto final /seats.
 */