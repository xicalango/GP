package gp.example;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;



public class Beispiel_5b {

  //Ein FPSAnimator zum flexibleren Animationshandling 
  static FPSAnimator animator = null;

  static class WinRenderer extends GLCanvas
    implements GLEventListener
    {

      private GL2 gl;
       private GLU glu;



       public WinRenderer(){
           super();
       }

       public WinRenderer(GLCapabilities cap){
         super(cap);
       }


        float angle = 0.0f;

        void spin(){
            angle+=2.0f;
        }

        public void display(GLAutoDrawable gLDrawable){
          gl = gLDrawable.getGL().getGL2();
          glu = new GLU();
          GLUT glut = new GLUT();
          gl.glClear(gl.GL_COLOR_BUFFER_BIT);
          gl.glLoadIdentity();
          //gl.glRotatef(angle,1,1,1);
          glu.gluLookAt(0,0,15,0,0,0,0,1,0);
          gl.glRotatef(angle,1,1,1);
          glut.glutWireCube(2.0f);
          //gl.glRotatef(angle,1,1,1);
          gl.glFlush();
          spin();
        }

        public void displayChanged(GLAutoDrawable gLDrawable,
            boolean modeChanged, boolean deviceChanged){}

        public void init(GLAutoDrawable gLDrawable){}

        public void reshape(GLAutoDrawable gLDrawable, int x, int y,
                            int width, int height){
          gl = gLDrawable.getGL().getGL2();
          glu = new GLU();
          gl.glViewport(0,0,width,height);
          gl.glMatrixMode(gl.GL_PROJECTION);
          gl.glLoadIdentity();
          //gl.glOrtho(-1,1,-1,1,-1,1);
          glu.gluPerspective(60,width/height,1,100);
          gl.glMatrixMode(gl.GL_MODELVIEW);

        }

		@Override
		public void dispose(GLAutoDrawable drawable) {
			// TODO Auto-generated method stub
			
		}
     }


     public static void main(String[] args) {
       Frame frame = new Frame("rotierender Drahtwürfel mit FPSAnimator");
       GLCapabilities cap = new GLCapabilities(GLProfile.getDefault());
       cap.setDoubleBuffered(true);
       WinRenderer canvas = new WinRenderer(cap);
       canvas.addGLEventListener(canvas);
       //zwanzig Bilder pro Sekunde einstellen
       animator = new FPSAnimator(canvas, 20);
       frame.add(canvas);
       frame.addWindowListener(new WindowAdapter()
       {
             public void windowClosing(WindowEvent e)
            {
              animator.stop();
              System.exit(0);
            }
       });
       frame.setSize(640, 480);
       frame.show();
       animator.start();
       canvas.requestFocus();
     }


}
