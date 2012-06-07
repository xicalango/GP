package gp.gp07a04;

import java.awt.event.KeyEvent;

import gp.physics.Joint;
import gp.physics.PhysicWorld;
import gp.physics.RotatingGravityJoint;
import gp.planets.Earth;
import gp.planets.Moon;
import gp.planets.Pluto;
import gp.planets.Sun;
import gp.world.Entity;
import gp.world.World;
import gp.world.camera.EntityFollowerSphereCamera;
import gp.world.camera.SphereCamera;
import gp.world.texture.ListTextureLoader;
import gp.world.texture.TextureStore;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.swing.text.PlainDocument;

import com.jogamp.opengl.util.gl2.GLUT;

public class GP07A04World extends PhysicWorld{

	private static final float DELTA = 0.07f;
	private EntityFollowerSphereCamera camera;
	
	private float radius = 10f;
	
	private int currentEntity = 0;
	private Earth earth;
	private Moon moon;
	private Pluto pluto;
	private Sun sun;
	
	@Override
	protected void initializeTextureStore(GL2 gl, GLU glu, GLUT glut, TextureStore store) {
		super.initializeTextureStore(gl, glu, glut, store);
		
		ListTextureLoader ltl = new ListTextureLoader(store);
		
		ltl.load("textures.lst");
	}
	
	@Override
	public void init(GL2 gl, GLU glu, GLUT glut) {
		
		earth = new Earth();
		add(earth);
		
		moon = new Moon();
		add(moon);
		
		pluto = new Pluto();
		add(pluto);
		
		sun = new Sun();
		add(sun);
		
		RotatingGravityJoint moonEarthJoint = new RotatingGravityJoint(earth, moon);
		moonEarthJoint.setRadius(5f);
		moonEarthJoint.setRotatingSpeed(-.04f);
		
		RotatingGravityJoint sunEarthJoint = new RotatingGravityJoint(sun, earth);
		sunEarthJoint.setRadius(30f);
		sunEarthJoint.setRotatingSpeed(.01f);
		
		RotatingGravityJoint sunPlutoJoint = new RotatingGravityJoint(sun, pluto);
		sunPlutoJoint.setRadius(70f);
		sunPlutoJoint.setRotatingSpeed(.005f);
		
		add(moonEarthJoint);
		add(sunEarthJoint);
		add(sunPlutoJoint);
		
		camera = new EntityFollowerSphereCamera();
		camera.setRadius(radius);
		camera.setFollowingEntity(earth);
		setCamera(camera);
		
		super.init(gl, glu, glut);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		// Laengengrad erhoehen
		case KeyEvent.VK_RIGHT:
			camera.rotateLng(DELTA);
			break;
		// Laengengrad erniedrigen
		case KeyEvent.VK_LEFT:
			camera.rotateLng(-DELTA);
			break;
		// Breitengrad erhoehen
		case KeyEvent.VK_UP:
			camera.rotateLat(DELTA);
			break;
		// Breitengrad erniedrigen
		case KeyEvent.VK_DOWN:
			camera.rotateLat(-DELTA);
			break;
		// view-up nach rechts rotieren
		case KeyEvent.VK_R:
			camera.rotateLR(DELTA);
			break;
		// view-up nach links rotieren
		case KeyEvent.VK_L:
			camera.rotateLR(-DELTA);
			break;
			
		case KeyEvent.VK_PLUS:
			radius -= DELTA*2;
			camera.setRadius(radius);
			break;
			
		case KeyEvent.VK_MINUS:
			radius += DELTA*2;
			camera.setRadius(radius);
			break;
			
		case KeyEvent.VK_N:
			
			currentEntity++;
			
			if(currentEntity >= numEntities()) {
				currentEntity = 0;
			}
			
			camera.setFollowingEntity(get(currentEntity));
			
			break;

		case KeyEvent.VK_0:
			
			camera = new EntityFollowerSphereCamera();
			camera.setRadius(radius);
			camera.setFollowingEntity(get(currentEntity));
			setCamera(camera);
			break;

		case KeyEvent.VK_F:
			camera.setHoldPosition(!camera.isHoldPosition());
			break;
		}
		
		

		super.keyPressed(e);

	}
	
}
