package com.mdj20.scrumchessswing.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mdj20.scrumchessswing.RankAndFile;

public class SquarePanel extends JPanel implements RankAndFile {
	int rank;
	int file;
	Color normalColor;
	JLabel jLabel;
	int defaultSize = 100;
	BoardPanel boardPanel;

	public SquarePanel(int rank, int file, Color backGround, BoardPanel boardPanel){
		this.rank = rank;
		this.file = file;
		this.normalColor = backGround;
		this.boardPanel = boardPanel;
		this.setPreferredSize(new Dimension(this.defaultSize,this.defaultSize));
		jLabel = new JLabel();
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, (int) 54.0));
		this.setLayout(new BorderLayout());
		this.add(jLabel,SwingConstants.CENTER);
		this.setBackground(normalColor);
		initMouseClickListener();
	}
	
	private void initMouseClickListener(){
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				boardPanel.squareClick((SquarePanel)e.getSource());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
	}
	

	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public int getDefaultSize() {
		return defaultSize;
	}
	public int getRank() {
		return rank;
	}
	public int getFile() {
		return file;
	}
	public Color getNormalColor() {
		return normalColor;
	}
	public JLabel getjLabel() {
		return jLabel;
	}
	
}
