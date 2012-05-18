package gp;

public class ParabelTimerThread implements Runnable{
	private ParabelController controller;
	private int fps;

	private Thread thread;
	private float t;
	
	
	public ParabelTimerThread(ParabelController controller, int fps) {
		super();
		this.controller = controller;
		this.fps = fps;
		t=0;
	}
	
	public void start() {
		thread = new Thread(this,"ParabelTimerThread");
		
		thread.start();
	}
	
	public void stop() {
		thread.interrupt();
	}


	@Override
	public void run() {
		while(!thread.isInterrupted()) {
			
			try {
				Thread.sleep(1000/fps);
			} catch (InterruptedException e) {
				thread.interrupt();
			}
			
			controller.setTime(t);
			t+=0.1;
		}
	}
	
	
}
