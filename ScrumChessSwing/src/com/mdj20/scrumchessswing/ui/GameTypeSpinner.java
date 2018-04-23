package com.mdj20.scrumchessswing.ui;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import com.scrumchess.userrequests.NewGameRequest;

public class GameTypeSpinner extends JSpinner{
	
	GameTypeSpinner(){
		SpinnerListModel model = new SpinnerListModel(NewGameRequest.NewGameConfig.values());
		super.setModel(model);
	}

}
