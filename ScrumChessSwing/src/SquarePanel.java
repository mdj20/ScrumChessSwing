import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SquarePanel extends JPanel {
	int rank;
	int file;
	Color backgroundColor;
	JLabel jLabel ;
	int defaultSize = 100;

	SquarePanel(int rank, int file, Color backGround){
		this.rank = rank;
		this.file = file;
		this.backgroundColor = backGround;
		this.setPreferredSize(new Dimension(this.defaultSize,this.defaultSize));
		jLabel = new JLabel();
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, (int) 23.0));
		this.setLayout(new BorderLayout());
		this.add(jLabel,SwingConstants.CENTER);
		this.setBackground(backgroundColor);
	}
	
}
