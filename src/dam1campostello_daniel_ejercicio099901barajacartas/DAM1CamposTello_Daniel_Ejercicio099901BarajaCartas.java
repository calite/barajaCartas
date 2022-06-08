/*
Ejercicio099901BarajaCartas Sencillo. Versión Avanzada
Hacer un programa en Java que muestre de forma aleatoria una mano de cartas para una partida de Mus.
Versión Avanzada : El diseño del Programa debe poder usarse fácilmente para cualquier reparto de cartas de cualquier Juego y/o Baraja de Naipes de mesa
como Poker, Cinquillo, Tute, etc.
Ejemplo de Salida :
[5 de Espadas, Sota de Copas, Sota de Espadas, 5 de Copas]
[6 de Copas, 4 de Bastos, 2 de Bastos, Caballo de Bastos]
[Caballo de Espadas, As de Copas, 3 de Bastos, Rey de Oros]
[Sota de Bastos, As de Oros, 5 de Oros, 6 de Bastos]
Ayuda.
Construir un mazo de cartas : “As de Oros”, “Dos de Oros”, ..... “Rey de Bastos”, con una colección adecuada.
Usar Collections.shuffle para barajear.
Ir extrayendo del mazo tantas cartas como sean necesarias y hacerlo para cada uno de los jugadores.
 */
package dam1campostello_daniel_ejercicio099901barajacartas;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Campos
 */
public class DAM1CamposTello_Daniel_Ejercicio099901BarajaCartas {

  /**
   * @param args the command line
   * arguments
   */
  public static void main(String[] args) {
    //ACTUALMENTE SOLAMENTE VALE PARA EL MUS
    //declaramos dos arrays para el valor de la carta y los palos
    String[] palos = {"Oros", "Bastos", "Copas", "Espadas"};
    String[] valor = {"As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey"};
    //declaramos el array a rellenar
    String[] baraja = new String[palos.length * valor.length];
    //se declara un contador, se usara para rellenar el array
    int count = 0;
    //se rellena el array
    for (String i : palos) {
      for (String j : valor) {
        baraja[count] = j + " de " + i;
        count++;
      }
    }
    //pasamos la baraja[] a arraylist<>
    List<String> mazo = new ArrayList<>(Arrays.asList(baraja));
    //desordenamos el mazo
    Collections.shuffle(mazo);
    //se usara para construir la mano
    String nroJugadores = "";
    String nroCartas = "";
    do {
      //se recogen el numero de jugadores y el numero de cartas
      nroJugadores = JOptionPane.showInputDialog("Introduce numero de jugadores: ");
      nroCartas = JOptionPane.showInputDialog("Introduce numero de cartas: ");
      //devolvemos un mensaje de error si la cantidad elegida es superior al nro de cartas de la baraja
      if(parseInt(nroJugadores) * parseInt(nroCartas) > palos.length * valor.length) {
        JOptionPane.showMessageDialog(null, "La cantidad de cartas a repartir no puede ser superior a la baraja.");
      }
    } while (parseInt(nroJugadores) * parseInt(nroCartas) > palos.length * valor.length);
    //inicio y limite de las sublistas
    int inicial = 0;
    int limite = parseInt(nroCartas);
    //bucle para repartir por nroJugadores
    System.out.println("La mano a jugar: ");
    for (int i = 0; i < parseInt(nroJugadores); i++) {
      System.out.println("");
      System.out.print("|");
      //bucle para hacer sublistas segun el nro de cartas
      for (String cartas : mazo.subList(inicial, limite)) {
        System.out.print(cartas + " | ");
      }
      inicial += parseInt(nroCartas);
      limite += parseInt(nroCartas);
    }

  }
}
