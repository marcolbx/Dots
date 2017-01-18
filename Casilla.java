package com.mygdx.dots;

/**
 * Created by LozanoBethke1 on 11-01-2017.
 */
public class Casilla {

    private int color=1;
    private boolean seleccionada=false;
    private FichaInt fichaint;
    //Constructor
    public Casilla(){
        this.fichaint= new FichaInt();
        this.color=fichaint.getColor();
        this.seleccionada=false;

    }


    //Getters y Setters

    public int getColor(){
        return fichaint.value;
    }

    public void setColor(int color){
        fichaint.value=color;
        this.color=fichaint.value;
    }
    public void setColorRandom(){
        fichaint.setColorRandom();
        this.color = fichaint.getColor();
    }

    public void setSeleccion(boolean seleccion){
        this.seleccionada=seleccion;
    }

    public boolean getSeleccion(){
        return this.seleccionada;
    }
}
