package gp;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class Stumpf implements Renderable {

	public static class Factory implements RenderableFactory {
		@Override
		public Renderable create(String... pars) {
			
			float rad1 = Float.parseFloat(pars[0]);
			float rad2 = Float.parseFloat(pars[1]);
			float height = Float.parseFloat(pars[2]);
			int n = Integer.parseInt(pars[3]);
			
			return new Stumpf(rad1, rad2, height, n);
		}
	}
	
	private float rad1;
	private float rad2;
	private float height;
	private int n;
	
	public Stumpf(float rad1, float rad2, float height, int n) {
		super();
		this.rad1 = rad1;
		this.rad2 = rad2;
		this.height = height;
		this.n = n;
	}
	
	@Override
	public void render(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub

		GP03A05.Stumpf(gl, rad1, rad2, height, n);
	}





}
