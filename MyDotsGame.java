package com.mygdx.dots;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.OrthographicCamera;

import java.util.ArrayList;

import sun.security.provider.SHA;

public class MyDotsGame extends ApplicationAdapter implements InputProcessor {
	ShapeRenderer shapeRenderer;
	public static final int WIDTH =480;
	public static final int HEIGHT = 800;

	private Tablero tablero;
	private SpriteBatch batch;
	private Texture[] dots;

	OrthographicCamera camera;
	static final int Worldsize = 2100;
	static final float CAMARA_X = 1050;
	static final float CAMARA_Y = 1050;
	int x=0,y=0;

	Vector3 lastTouch;

	@Override
	public void create() {
		Gdx.input.setInputProcessor(this);
		shapeRenderer = new ShapeRenderer();
		camera = new OrthographicCamera();

		tablero= new Tablero();
		tablero.LlenarMatriz();
		batch = new SpriteBatch();
		dots= new Texture[FichaInt.colores +1];
		dots[FichaInt.COLOR_AZUL]= new Texture("blue.png");
		dots[FichaInt.COLOR_AMARILLO]= new Texture("yellow.png");
		dots[FichaInt.COLOR_MORADO]= new Texture("purple.png");
		dots[FichaInt.COLOR_ROJO]= new Texture("red.png");
		dots[FichaInt.COLOR_VERDE]= new Texture("green.png");

	}

	@Override
	public void resize(int width, int height) {
		float aspectratio = 1.0f * width / height;
		camera.setToOrtho(false, width, height);
		camera.viewportHeight= 2*2100;
		camera.viewportWidth = aspectratio * camera.viewportHeight;
		Gdx.app.log("resize", "viewportHeight="+camera.viewportHeight+",camera.viewportWidth="+camera.viewportWidth);
		Gdx.app.log("resize", "center viewportWidth="+ (0.5f * camera.viewportWidth));
		camera.position.set(CAMARA_X, CAMARA_Y, 0);

	}

	public Texture getImage(int color) {
		return dots[color];
	}
	
	private void draw() {
		batch.begin();
		tablero.draw(batch, this);
		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);   //1111 es blanco
		//0011 para azul
		//1001 para rojo
		//1100 para amarillo
		//0101 para verde
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		shapeRenderer.setProjectionMatrix(camera.combined);
		draw();
	/*	if(tablero.rectlinecolor==0)
			shapeRenderer.setColor(0,0,1,1);
		else if(tablero.rectlinecolor==1)
			shapeRenderer.setColor(1,0,0,1);
		else if(tablero.rectlinecolor==2)
			shapeRenderer.setColor(1,1,0,0);
		else if(tablero.rectlinecolor==3)
			shapeRenderer.setColor(0,1,0,1);
		else
			shapeRenderer.setColor(0,0,0,0);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.rectLine(x,y,Gdx.input.getX(),Worldsize-Gdx.input.getY(),20);*/
		shapeRenderer.end();
	}

	private void updatePosition() {
		int x = Gdx.input.getX();
		int y = Gdx.input.getY();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		shapeRenderer.dispose();
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Gdx.app.log("touchDown", "x="+screenX+",y="+screenY);
		//	tablero.RectLineColor(x,y);

		//	dot = screen2Dot(screenX, screenY);
		//	if(dot != null){
		//		camino.add(dot);
		lastTouch = camera.unproject(new Vector3(screenX, screenY, 0));
		//	}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		Gdx.app.log("touchUp", "x="+screenX+",y="+screenY);
		//dot = null;
		//camino = new ArrayList<Dot>();
		lastTouch = null;
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Gdx.app.log("touchDragged", "x="+screenX+",y="+screenY);
		//Dot dot2 = screen2Dot(screenX, screenY);
		//if((dot != null) && (dot2 != null)){
		//	if(isValid(dot.fila, dot.columna, dot2.fila, dot2.columna)){
		//		if(!existInPath(dot2)){
		//			camino.add(dot2);
		//			dot = dot2;
		//		}
		//	}
		//}

		lastTouch = camera.unproject(new Vector3(screenX, screenY, 0));

		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}

