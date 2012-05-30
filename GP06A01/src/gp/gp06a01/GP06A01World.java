package gp.gp06a01;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.OrthoPerspective;
import gp.world.World;
import gp.world.camera.DefaultCamera;

public class GP06A01World extends World {

	private StepTabExample stepTabExample;
	private MachBandExample machBandExample;
	private SimultaneousContrastExample simultaneousContrastExample;
	private RadiatingLinesExample radiatingLinesExample;

	
	public GP06A01World() {
		
		DefaultCamera camera = new DefaultCamera();
		camera.setEyeXYZ(5,0,7);
		camera.setCenterXYZ(5, 0, 0);
		camera.setViewUpXYZ(0, 1, 0);
		setCamera(camera);
		
		OrthoPerspective op = new OrthoPerspective();
		
		op.setParameters(-10, 10, -10, 10, -10, 10);
		
		setPerspective(op);
		
		stepTabExample = new StepTabExample();
		stepTabExample.setY(4.5f);
		
		add(stepTabExample);
		
		machBandExample = new MachBandExample();
		machBandExample.setY(2f);
		
		add(machBandExample);
		
		simultaneousContrastExample = new SimultaneousContrastExample();
		simultaneousContrastExample.setY(-0.5f);
		
		add(simultaneousContrastExample);
		
		radiatingLinesExample = new RadiatingLinesExample();
		radiatingLinesExample.setY(-4.5f);
		
		add(radiatingLinesExample);
	}
	
	@Override
	protected void preRendering(GL2 gl, GLU glu, GLUT glut) {
		//gl.glClearColor(.55f, .55f, .55f, 0);
		gl.glClearColor(1f, 1f, 1f, 0);
	}
	
}
