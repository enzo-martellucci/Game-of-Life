package lifegame.view.action;

import lifegame.Controller;
import lifegame.view.util.UIFactory;

import javax.swing.*;
import java.awt.*;

public class PanelAction extends JPanel
{
	// attributes
	private Controller ctrl;

	private JButton btnPrev;
	private JButton btnPause;
	private JButton btnNext;
	private JButton btnRestart;
	private JButton btnFile;
	private JButton btnSave;


	// Constructor
	PanelAction(Controller ctrl)
	{
		// Parameters
		this.ctrl = ctrl;
		this.setLayout(new GridLayout(2, 3, 5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

		// Creation
		this.btnPrev    = UIFactory.createBtn("backward.png");
		this.btnPause   = UIFactory.createBtn("pause.png");
		this.btnNext    = UIFactory.createBtn("forward.png");
		this.btnRestart = UIFactory.createBtn("restart.png");
		this.btnFile    = UIFactory.createBtn("load.png");
		this.btnSave    = UIFactory.createBtn("save.png");

		// Positioning
		this.add(this.btnPrev);
		this.add(this.btnPause);
		this.add(this.btnNext);
		this.add(this.btnRestart);
		this.add(this.btnFile);
		this.add(this.btnSave);
	}
}
