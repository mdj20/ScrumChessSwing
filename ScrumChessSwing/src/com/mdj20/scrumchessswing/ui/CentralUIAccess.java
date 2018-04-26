package com.mdj20.scrumchessswing.ui;

import com.mdj20.scrumchessswing.backend.BackendAccess;
import com.mdj20.scrumchessswing.ui.components.BoardPanel;
import com.mdj20.scrumchessswing.ui.components.InfoPanel;

public interface CentralUIAccess extends UIActionControl, UIInfoAccess {
	public void setBoardPanel(BoardPanel boardPanel);
	public void setInfoPanel(InfoPanel infoPanel);
	public void setBackendAccess(BackendAccess backendAccess);
}
