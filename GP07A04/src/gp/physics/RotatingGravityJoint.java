package gp.physics;

import gp.world.Entity;

public class RotatingGravityJoint implements Joint {

	private Entity centerEntity;
	private Entity rotatingEntity;
	
	private float rotatingSpeed = 0.1f;
	private float currentAngle = 0;
	
	private float radius = 1f;
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		final float cx = centerEntity.getCurX();
		final float cy = centerEntity.getCurY();
		final float cz = centerEntity.getCurZ();
		
		float rx = cx + (float)(radius * Math.cos(currentAngle));
		float ry = cy + (float)(radius * Math.sin(currentAngle));
		float rz = cz; //TODO ...
		
		rotatingEntity.setXYZ(rx, ry, rz);
		
		currentAngle += rotatingSpeed;
		

	}

	public RotatingGravityJoint(Entity centerEntity, Entity rotatingEntity) {
		this.centerEntity = centerEntity;
		this.rotatingEntity = rotatingEntity;
	}

	public float getRotatingSpeed() {
		return rotatingSpeed;
	}

	public void setRotatingSpeed(float rotatingSpeed) {
		this.rotatingSpeed = rotatingSpeed;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

}
