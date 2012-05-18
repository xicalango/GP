package gp;

public class GP04A02 {

	
	public static boolean same_side(float[][] polygon1, float[][] polygon2) {
		
		Polygon3D p1 = Polygon3D.fromArray(polygon1);
		Polygon3D p2 = Polygon3D.fromArray(polygon2);
		 
		Vector3D p11 = p1.getPoint(0);
		Vector3D p12 = p1.getPoint(1);
		Vector3D p13 = p1.getPoint(2);
		
		Vector3D v12 = p12.sub(p11);
		Vector3D v13 = p13.sub(p11);
		
		Vector3D n = v12.vectorProduct(v13);
		
		float s = Math.signum(n.scalarProduct(p2.getPoint(0)));
		
		Vector3D[] p2points = p2.getPoints();
		
		for( int i = 1; i < p2points.length; i++ ) {
			
			if( Math.signum(n.scalarProduct(p2points[i].sub(p11))) != s) {
				return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
