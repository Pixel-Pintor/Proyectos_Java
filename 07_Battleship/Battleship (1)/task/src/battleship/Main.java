package battleship;

public class Main {

    public static void main(String[] args) {
        BattleField battleField = new BattleField();
        battleField.startBattleFieldGame();
    }
}

/*
STAGE 01
En esta estapa, debes organizar tus barcos en el campo de juego.
Antes de comenzar, analicemos las convenciones del juego.
1. En un campo de 10x10, la primera fila debe contener numeros del 1
al 10 que indiquen la columna, y la primera columna debe contener letras
de la A a la J que indiquen la fila.
2. El simbolo ~ denota la niebla de la guerra: el area desconocida en el
campo del oponente y el area aun intacta en su campo.
3. El simbolo O denota una celda con su nave, X denota que el barco,
fue golpeado, y M significa una falla.
4. Tienes 5 barcos: el portaviones tiene 5 celdas, el acorazado tiene
4 celdas, el submarino tiene 3 celdas, el crucero tiene 3 celdas y el
destructor tiene 2 celdas. Empieza a color tus barcos con el mas grande.
5. Para colocar un barco, ingresa dos coordenadas: el comienzo y el final
6. Si ocurre un error en las coordenadas de entrada, su programa debe
informarlo. El mensaje debe contener la palabra Error.
 */