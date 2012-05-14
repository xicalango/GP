package gp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.swing.JFrame;

public class GP03A05 {

	public static void Stumpf( GL2 gl,  float rad1, float rad2, float height, int n) {		
		
		final double step = (2 * Math.PI) / n;
		double alpha = 0f;
		
		gl.glBegin(GL.GL_LINE_LOOP);
		
		for( int i = 0; i < n; i++ ) {
			
			gl.glVertex3d( Math.cos(alpha) * rad1,  Math.sin(alpha) * rad1, 0);
			gl.glVertex3d( Math.cos(alpha) * rad2,  Math.sin(alpha) * rad2, height);
			
			gl.glVertex3d( Math.cos(alpha+step) * rad2,  Math.sin(alpha+step) * rad2, height);
			gl.glVertex3d( Math.cos(alpha+step) * rad1,  Math.sin(alpha+step) * rad1, 0);

			gl.glVertex3d( Math.cos(alpha) * rad1,  Math.sin(alpha) * rad1, 0);

			alpha += step;
		}
		
		gl.glEnd();
	}
	
	
	public static void Pyramide( GL2 gl, float rad, float height, int n, int m ) {
		
		final int nPyramid = m+1;
		final float heightStumpf = height/nPyramid;
		
		for( int i = 1; i <= nPyramid; i++ ) {
			Stumpf( gl, rad * (nPyramid-(i-1))/nPyramid , rad * (nPyramid-i)/nPyramid, heightStumpf, n);
			gl.glTranslatef(0, 0, heightStumpf);
		}
		
	}
	
	@Deprecated
	public static void nEck3d(GL2 gl, double x0, double y0, double z0, double r, int n) {
		
		final double step = (2 * Math.PI) / n;
		double alpha = 0f;
		
		gl.glBegin(GL.GL_LINE_LOOP);
		
		for( int i = 0; i < n; i++ ) {
			
			gl.glVertex3d( x0 + Math.cos(alpha) * r,  y0 + Math.sin(alpha) * r, z0);
			
			alpha += step;
		}
		
		gl.glEnd();
				
		
	}

	
	public static void main(String[] args) {
		
		Map<String, RenderableFactory> renderableMap = new HashMap<String, RenderableFactory>();
		renderableMap.put("Pyramide", new Pyramide.Factory());
		renderableMap.put("Stumpf", new Stumpf.Factory());
		
		RenderableFactory factory = renderableMap.get(args[0]);
		Renderable r = factory.create(Arrays.copyOfRange(args, 1, args.length));
		
		JFrame jf = new JFrame();
		final WinRenderer canvas = new WinRenderer(r);
		jf.add(canvas);
		jf.setSize(640, 480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		canvas.requestFocus();
	}
	
	
}
