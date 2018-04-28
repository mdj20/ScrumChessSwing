package com.mdj20.scrumchessswing.ui.components;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import com.scrumchess.userrequests.GameConfiguration;

public class GameTypeSpinner extends JSpinner{
	
	GameTypeSpinner(){
		SpinnerListModel model = new SpinnerListModel(GameConfiguration.values());
		super.setModel(model);
	}

}
