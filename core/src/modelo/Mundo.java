package modelo;


import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

//esta clase es la que crea las paredes del castillo y el personaje
public class Mundo {

    private List<Bloque> paredes;
    private Guerrero jabato;

    public Mundo() {
        paredes = new ArrayList<>();
        creaMundoDemo();
    }

    private void creaMundoDemo() {
        jabato = new Guerrero(new Vector2(4, 2)); //esto es la posicion en la que aparece el personaje en la pantalla. Con estas coordenadas me aparece al principio

        //con este for se añade un bloque a cada posicion xy de la pantalla. Se llenan esas posiciones en el array
        for (int i = 0; i < 10; i++) { //este for tenia el i-- y eso hace que no se ejecute. 10 es el numero de bloques que va a generar por pantalla
            //esto llena las dos primeras filas verticales
            paredes.add(new Bloque(new Vector2(i, 0)));
            paredes.add(new Bloque(new Vector2(i, 7)));

            if (i > 2) {
                paredes.add(new Bloque(new Vector2(i, 1)));
            }//esto no lo entiendo que hace

            //esto llena los dos bloques horizontales
            paredes.add(new Bloque(new Vector2(9, 2)));
            paredes.add(new Bloque(new Vector2(9, 3)));
            paredes.add(new Bloque(new Vector2(9, 4)));
            paredes.add(new Bloque(new Vector2(9, 5)));
            paredes.add(new Bloque(new Vector2(9, 6)));//añado este bloque que quedaba en blanco

            paredes.add(new Bloque(new Vector2(6, 3)));
            paredes.add(new Bloque(new Vector2(6, 4)));
            paredes.add(new Bloque(new Vector2(6, 5)));
            paredes.add(new Bloque(new Vector2(6, 6)));//añado este bloque que quedaba en blanco

            //los fragmentos en blanco son los espacios libres
       }
    }
    public List<Bloque> getParedes() {
        return paredes;
    }

    public void setParedes(List<Bloque> paredes) {
        this.paredes = paredes;
    }

    public Guerrero getJabato() {
        return jabato;
    }

    public void setJabato(Guerrero jabato) {
        this.jabato = jabato;
    }


}

