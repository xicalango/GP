package gp;

public class Cube implements Intersectionable{

	@Override
	public Vector3D[] getIntersections(Ray3D ray) {
		
		final Vector3D start = ray.getStart();
		final Vector3D dir = ray.getDir();
		
		final float xa = start.getX();
		final float ya = start.getY();
		final float za = start.getZ();
		
		final float xr = dir.getX();
		final float yr = dir.getY();
		final float zr = dir.getZ();

		
		
		// TODO Auto-generated method stub
		return null;
	}

}
