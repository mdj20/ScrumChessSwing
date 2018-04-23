package com.mdj20.scrumchessswing.ui.workers;

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import com.mdj20.scrumchessswing.background.GameControl;
import com.mdj20.scrumchessswing.ui.UIControl;
import com.mdj20.scrumchessswing.Move;

public class MoveExecuteWorker extends SwingWorker<Boolean, Void> {

	UIControl uIControl;
	Move move;
	
	public MoveExecuteWorker(UIControl uIControl, Move move){
		this.uIControl = uIControl;
		this.move = move;
	}
	
	@Override
	protected Boolean doInBackground() throws Exception {
		GameControl gameControl = uIControl.getGameControl();
		return gameControl.tryMove(move);
	}
	
	@Override
	protected void done() {
		try {
			if(get()) {
				System.out.println(uIControl.getGameControl().getFen());
				uIControl.setBoardPanelUIThread(uIControl.getGameControl().getShortFen());
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
