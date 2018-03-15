import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.mdj20.scrumchessswing.SquarePanel;



public class SwingGridLayout {
	
	public static void main(String args[]) throws InterruptedException{
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				initGUI();
			}
		});
	}
	
	private static void initGUI(){
		
		JFrame topLevel = new JFrame();
		topLevel.setLayout(new BorderLayout());
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(8,8));
		topLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPanel.setPreferredSize(new Dimension(800,800));
		topLevel.add(jPanel);
	
		Color white = Color.WHITE;
		Color black = Color.BLACK;
		ArrayList<SquarePanel> squares = new ArrayList<SquarePanel>();
		int c = 0;
		for(int i = 0 ; i < 64 ; i++) {
			SquarePanel temp;
			if(i%8==0) {
				c++;
			}
			if(c%2==0) {
				temp = new SquarePanel(i,i,white);
			}
			else {
				temp = new SquarePanel(i,i,black);
			}
			squares.add(temp);
			c++;
		}
		for(JPanel jp : squares ) {
			jPanel.add(jp);
		}
		
		topLevel.add(jPanel);
		topLevel.pack();
		topLevel.setVisible(true);
		
		JLabel tLab = (JLabel) squares.get(0).getComponent(0);
		tLab.setText("H");
		squares.get(0).setBackground(Color.YELLOW);
	}

}
