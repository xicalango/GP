package gp;

import java.util.HashSet;
import java.util.Set;

public class Cylinder implements Intersectionable {

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
		
		final float xas = xa*xa;
		final float yrs = yr*yr;
		final float xrs = xr*xr;
		final float yas = ya * ya;

		
		final float lsqrt = (1-xas) * yrs + 2 * xa * xr * ya * yr - xrs * yas + xrs;
		
		if(lsqrt < 0) {
			GP10.log(lsqrt +" < 0");
			return new Vector3D[0];
		}
		
		final float denom = yrs + xrs;
		
		if(denom == 0) {
			GP10.log("Denominator == 0");
		}
		
		final float l1 = - ( (float)Math.sqrt(lsqrt) + ya*yr + xa*xr)/denom;
		final float l2 = ((float)Math.sqrt(lsqrt) - ya*yr - xa*xr)/denom;
		
		if( l1 < 0 && l2 < 0 ) { //beide < 0? kein schnittpunkt (Zylinder hinter halbgerade)
			GP10.log("l1<0,l2<0");
			return new Vector3D[0];
		}

		final float[] ls = new float[] { l1, l2 };
		
		final Set<Vector3D> intersections = new HashSet<Vector3D>();
		
		for( float l : ls ) {
			
			GP10.log("l: " + l);
			
			if( l < 0 ) {
				GP10.log(l + " < 0");
				continue;
			}

			final float sz = za + l * zr; //schnittpunkt z
			
			if( sz < 0 || sz > 1 ) { // wir treffen den zylinder in z richtung nicht.
				GP10.log(sz +"< 0 || > 1");
				continue;
			}

			final float sx = xa + l * xr;
			final float sy = ya + l * yr;
			
			
			GP10.log("0 =? " + (sx*sx + sy*sy - 1));
			
			if(sx*sx + sy*sy - 1 == 0) { //threshold?
				GP10.log("0 == " + (sx*sx + sy*sy - 1));

				intersections.add(new Vector3D(sx, sy, sz));
			}
		}
		
		
		return intersections.toArray(new Vector3D[0]);
	}

}
