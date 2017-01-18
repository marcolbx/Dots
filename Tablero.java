package com.mygdx.dots;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by LozanoBethke1 on 11-01-2017.
 */
public class Tablero {

    private Casilla matriz[][];
    public int nfilas=6;
    public int ncolumnas=6;
    public int i=0,j=0;
    private float z,w;
    int aux,contador=0,contseleccionadas=0;
    public int color;
    public int rectlinecolor;

    public Tablero() {
        this.matriz = new Casilla[nfilas][ncolumnas];
    }

    public void LlenarMatriz(){
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                matriz[x][y]= new Casilla();
            }
        }

    }
//w/9 z/15
    public void draw(SpriteBatch batch, MyDotsGame game){

       // w=MyDotsGame.Worldsize/6;
        w=0;
           //Coordenadas para pintar , pq ya estan usadas X y Y
        for (int x=0; x < matriz.length; x++) {
           // z=MyDotsGame.Worldsize/6;    //seria el primero de abajo
              z=0;
            for (int y=0; y < matriz[x].length; y++)
            {     //Pinta la primera columna
                Texture texture = game.getImage(matriz[x][y].getColor());
                batch.draw(texture,w,z,45,45);

                z+=MyDotsGame.Worldsize/6;
            }
            w+=MyDotsGame.Worldsize/6;   //pasa a la 2da columna
        }

    }

    public void RectLineColor(int x,int y){
        w=MyDotsGame.Worldsize/6;z=MyDotsGame.Worldsize/6;
        int contadorcolumna=0, contadorfila=0;
        while(x<w){
            w+=MyDotsGame.Worldsize/6;
            contadorcolumna++;
        }
        while(y<z){
            z+=MyDotsGame.Worldsize/6;
            contadorfila++;
        }
        this.rectlinecolor = matriz[contadorfila][contadorcolumna].getColor();
    }




}
