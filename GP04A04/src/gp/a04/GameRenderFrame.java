package gp.a04;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gp.gui.WorldRenderFrame;

public class GameRenderFrame extends WorldRenderFrame implements ScoreUpdater {

	private static final int SCORE_LIMIT = 10;
	
	private JLabel scoreLabel;
	
	public GameRenderFrame(A04World world) {
		super(world);
		// TODO Auto-generated constructor stub
		
		world.setScoreUpdater(this);
		
		scoreLabel = new JLabel("");
		updateScore(0, 0);
		add(scoreLabel, BorderLayout.SOUTH);
	}
	
	/* (non-Javadoc)
	 * @see gp.a04.ScoreUpdater#updateScore(int, int)
	 */
	@Override
	public void updateScore(int score1, int score2) {
		scoreLabel.setText("Player1: " + score1 + " Player2: " + score2);
		
		if(score1 >= SCORE_LIMIT) {
			JOptionPane.showMessageDialog(this, "Player 1 wins!");
			quit();
		} else if(score2 >= SCORE_LIMIT) {
			JOptionPane.showMessageDialog(this, "Player 2 wins!");
			quit();
		}
		
		
		
	}

}
