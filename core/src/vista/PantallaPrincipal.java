package vista;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import controlador.ControladorPrincipal;
import modelo.Mundo;

public class PantallaPrincipal implements Screen, InputProcessor { //ha de implementar estas dos clases

    private Mundo castillo;
    private PintorMundos pintor;
    private ControladorPrincipal controlador;

    //variables para el metodo touchdown valores iniciales ????
    private int ancho;
    private int alto;


    public void show() {
        castillo = new Mundo();
        pintor = new PintorMundos(castillo);
        controlador = new ControladorPrincipal(castillo);
        Gdx.input.setInputProcessor (this); //se añade esto que implementa el InputProcessor

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //GL10 esta obsoleto, se cambia a GL20
        controlador.actualiza(delta);
        pintor.pinta();
    }

    public void resize(int width, int height) {
        pintor.setDimension(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    //se añaden estos metodos que controlan las teclas
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) controlador.izquierdaPulsada();
        if (keycode == Input.Keys.RIGHT) controlador.derechaPulsada();
        if (keycode == Input.Keys.Z) controlador.saltoPulsada();
        if (keycode == Input.Keys.X) controlador.disparoPulsado();
        return true;
    }

    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) controlador.izquierdaLiberada();
        if (keycode == Input.Keys.RIGHT) controlador.derechaLiberada();
        if (keycode == Input.Keys.Z) controlador.saltoLiberada();
        if (keycode == Input.Keys.X) controlador.disparoLiberada();
        return true;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int x, int y, int pointer, int button) {
        //en este metodo faltan por declarar las variables ancho y alto. No se que valores han de tener ni de donde salen. Las he creado al inicio sin inicializar.
        //No parece afectar al funcionamiento
        if (x < ancho / 2 && y > alto / 2) controlador.izquierdaPulsada();
        if (x > ancho / 2 && y > alto / 2) controlador.derechaPulsada();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean touchDragged(int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchMoved(int x, int y, int pointer, int button) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}
