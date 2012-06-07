package gp.physics;

import java.util.ArrayList;
import java.util.List;

import gp.world.Updateable;
import gp.world.World;

public class PhysicWorld extends World {

	private List<Joint> joints = new ArrayList<Joint>();

	public boolean add(Joint e) {
		return joints.add(e);
	}

	public boolean remove(Joint o) {
		return joints.remove(o);
	}
	
	@Override
	public void update() {
		super.update();
		
		for(Updateable j : joints) {
			j.update();
		}
	}
	
	
	
}
