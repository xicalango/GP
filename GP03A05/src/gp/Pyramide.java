package gp;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class Pyramide implements Renderable{

	public static class Factory implements RenderableFactory {
		@Override
		public Renderable create(String... pars) {
			
			float rad = Float.parseFloat(pars[0]);
			float height = Float.parseFloat(pars[1]);
			int n = Integer.parseInt(pars[2]);
			int m = Integer.parseInt(pars[3]);
			
			return new Pyramide(rad, height, n, m);
		}
	}
	
	private float rad;
	private float height;
	private int n;
	private int m;
	
	public Pyramide(float rad, float height, int n, int m) {
		super();
		this.rad = rad;
		this.height = height;
		this.n = n;
		this.m = m;
	}

	@Override
	public void render(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		GP03A05.Pyramide(gl, rad, height, n, m);
	}

}
