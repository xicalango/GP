package gp.world;


import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public abstract class World<T extends Renderable> implements Renderable, Iterable<T>, KeyListener {

	private Camera camera;
	private List<T> toRender = new ArrayList<T>();
	
	public World() {
		this(new Camera());
	}

	public World(Camera camera) {
		this.camera = camera;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public boolean add(T arg0) {
		return toRender.add(arg0);
	}

	public T get(int arg0) {
		return toRender.get(arg0);
	}

	public boolean remove(Object arg0) {
		return toRender.remove(arg0);
	}

	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		
		//camera.prepare(gl, glu, glut);
		
		
		for(Renderable r : this) {
			
			gl.glLoadIdentity();
			
			camera.prepare(gl, glu, glut);
			
			setupWorld( gl, glu, glut);

			r.render(gl, glu, glut);
		}
	}

	protected void setupWorld( GL2 gl, GLU glu, GLUT glut) {}
	
	@Override
	public Iterator<T> iterator() {
		return toRender.iterator();
	}

	public void init() {
		camera.init();
		
	}
	
}
