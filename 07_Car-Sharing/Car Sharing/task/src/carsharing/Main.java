package carsharing;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mainMenu();
    }
}

/*
Stage 2 - Mykola Danyliuk
- Ahora, implementemos la capacidad de trabajar con la base de datos desde su programa.
En esta etapa, creara un menu facil de usar que le permitira inicial sesion
como administrador, crear empresas y guardarlas en la base de datos.

Objetivos
Actualice su base de datos y agregue restricciones a la columna COMPANY:
    - La columna ID debe PRIMARY KEY y AUTO_INCREMENT
    - La columna NAME debe ser UNIQUE y NOT NULL
    - Los tipos de columna deben ser los mismos que en la etapa anterior
Implemente el menu con las siguientes opciones:
    1. Log in as a manager
    0. Exit
Si la opcion Exit es elegida, el programa debe detenerse. En caso de que el
usuario elija Log is as a manager, se debe imprimir el siguiente menu:
    1. Company list
    2. Create a company
    3. Back
Ahora, si el usuario eligio Back, el program debe imprimir el menu principal.
Company list debe imprimir la lista de empresas ordenadas por sus ID.
Sus indices parten de 1, por ejemplo:
    Company list:
    1. First company name
    2. Second company name
    3. Third company name
Si no hay empresas, imprimir The company list is empty!.
Si la opcion Create a company fue elegida, el program debe solicitar al
usuario que ingrese el nombre de una empresa con el mensaje Enter the company name:,
lea el nombre de la empresa y guardelo en la base de datos.
 */