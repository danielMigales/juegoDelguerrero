package vista;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import modelo.Bloque;
import modelo.Guerrero;
import modelo.Mundo;

//esta clase crea las texturas de los bloques y del personaje a partir de unas imagenes que se han de importar
public class PintorMundos {

    private Mundo mundo;
    //estas dos variables son una especie de zoom
    private static final float CAMARA_ANCHO = 10f;
    private static final float CAMARA_ALTO = 8f; //este es el valor que mas se aproxima al resultado que tiene que mostrar
    /**
     * Texturas
     **/
    private Texture jabatoImg;
    private Texture bloqueImg;
    private SpriteBatch spriteBatch;
    private int ancho;
    private int alto;
    private float ppuX;
    private float ppuY;

    public void setDimension(int an, int al) {
        this.ancho = an;
        this.alto = al;
        ppuX = (float) ancho / CAMARA_ANCHO;
        ppuY = (float) alto / CAMARA_ALTO;
    }

    public PintorMundos(Mundo m) {
        this.mundo = m;
        spriteBatch = new SpriteBatch();
        cargaTexturas();
    }

    //este procedimiento es el que obtiene las imagenes que se renderizan. Las obtiene de la carpeta assets qye hay que crear
    private void cargaTexturas() {

        //estas dos imagenes hay que buscarse la vida y buscarlas por internet
        jabatoImg = new Texture
                (Gdx.files.internal("images/guerrero.gif")); //renombro la imagen de jabato_01.gif a guerrero.gif
        bloqueImg = new Texture
                (Gdx.files.internal("images/bloque.png"));
    }

    public void pinta() {
        spriteBatch.begin();
        pintaBloques();
        pintaGuerrero();
        spriteBatch.end();
    }

    private void pintaBloques() {
        for (Bloque b : mundo.getParedes()) {
            spriteBatch.draw(bloqueImg,
                    b.getPosicion().x * ppuX,
                    b.getPosicion().y * ppuY,
                    b.getDimension().width * ppuX,
                    b.getDimension().height * ppuY);
        }
    }

    private void pintaGuerrero() {
        Guerrero g = mundo.getJabato();
        spriteBatch.draw(jabatoImg,
                g.getPosicion().x * ppuX,
                g.getPosicion().y * ppuY,
                g.getDimension().width * ppuX,
                g.getDimension().height * ppuY);
    }
}
