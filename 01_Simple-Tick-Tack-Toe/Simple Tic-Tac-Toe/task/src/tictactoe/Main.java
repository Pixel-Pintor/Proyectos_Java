package tictactoe;

import tictactoe.java.TicTacToe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TicTacToe newGame = new TicTacToe();
        newGame.startTicTacToeGame();
    }
}
/*
STAGE 4
Es hora de hacer el juego mas interactivo, ahora vamos a agregar la
capacidad para que un usuario haga un movimiento.
Para hacer esto, necesitamos dividir la cuadricula en celdas.
Supongamos que la celda superrior izquierda tiene las coordenadas (1, 1)
y la celda inferior derecha tiene las coordenadas (3, 3).

El programa debe solicitar al usuario que ingrese las coordenadas de
la celda donde desea realizar un movimiento.
Debe verificar si el usuario ingresa simbolos en lugar de numeros, o ingresa
coordenadas que representen celdas ocupadas o celdas que ni siquiera
estan en la cuadricula. Debe verificar la entrada del usuario y manejar
posibles errores.
1. Obtenga la cuadricula de 3x3 de la entrada como en las etapdas anteriores
2. Da salida a esta cuadricula de 3x3
3. Pide al usuario que haga un movimiento
4. El usuario debe ingresar 2 numeros que representen la celda donde
desea colocar su X. (Los 9 simbolos que representen el campo seran la
primera linea de entrada y los 2 numeros de coordenadas seran la segunda
linea de entrada).
5. Analice la entrada del usuario y muestre mensajes en las siguientes
situaciones:
- This cell is occupied! Choose another one! si la celda no esta vacia
- You should enter numbers! si el usuario ingresa simbolos no numericos
en la entrada de coordenadas.
Coordinates should be from 1 to 3! si el usuario ingresa coordenadas fuera
de la cuadricula del juego.
6. Actualice la cuadricula para incluir el movimiento del usuario e imprima
la cuadricula actualizada en consola.
Debe generar el campo solo 2 veces:
Una vez antes del movimiento del usuario y una vez despues de que el usuario
haya ingresado un movimiento legal.
 */
