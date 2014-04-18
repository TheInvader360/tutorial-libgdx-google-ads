package com.theinvader360.tutorial.libgdx.google.ads;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class AdTutorial implements ApplicationListener, GestureListener {
  private ActionResolver actionResolver;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
  AdTutorial(ActionResolver actionResolver) {
    this.actionResolver = actionResolver;
  }

  @Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		GestureDetector gd = new GestureDetector(this);
    Gdx.input.setInputProcessor(gd);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

  @Override
  public boolean tap(float x, float y, int count, int button) {
    actionResolver.showOrLoadInterstital();
    return true;
  }

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

  @Override
  public boolean touchDown(float x, float y, int pointer, int button) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean fling(float velocityX, float velocityY, int button) {
    return false;
  }

  @Override
  public boolean longPress(float x, float y) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean pan(float x, float y, float deltaX, float deltaY) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean panStop(float x, float y, int pointer, int button) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean zoom(float initialDistance, float distance) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
    // TODO Auto-generated method stub
    return false;
  }
}
