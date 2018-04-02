package com.mdj20.scrumchessswing.ui;

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import com.mdj20.scrumchessswing.BoardControl;
import com.mdj20.scrumchessswing.GameControl;
import com.mdj20.scrumchessswing.Move;

public class MoveExecuteWorker extends SwingWorker<Boolean, Void> {

	BoardControl boardControl;
	Move move;
	
	public MoveExecuteWorker(BoardControl boardControl, Move move){
		this.boardControl = boardControl;
		this.move = move;
	}
	
	@Override
	protected Boolean doInBackground() throws Exception {
		GameControl gameControl = boardControl.getGameControl();
		return gameControl.tryMove(move);
	}
	
	@Override
	protected void done() {
		try {
			if(get()) {
				System.out.println(boardControl.getGameControl().getFen());
				boardControl.setBoardPanelUIThread(boardControl.getGameControl().getFen());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
