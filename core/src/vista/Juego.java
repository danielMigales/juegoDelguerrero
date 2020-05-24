package vista;


import com.badlogic.gdx.Game;

//esta clase es la que crea la instancia de la pantalla principal
public class Juego extends Game {

    public void create() {
        this.setScreen(new PantallaPrincipal());
    }

}