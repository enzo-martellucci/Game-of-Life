package lifegame.view.action;

import lifegame.Controller;
import lifegame.view.util.UIFactory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PanelAction extends JPanel implements ActionListener
{
	// attributes
	private Controller ctrl;

	private JButton btnPrev;
	private JButton btnPP;
	private JButton btnNext;
	private JButton btnRestart;
	private JButton btnLoad;
	private JButton btnSave;

	private JFileChooser chooser;


	// Constructor
	PanelAction(Controller ctrl)
	{
		// Parameters
		this.ctrl = ctrl;
		this.setLayout(new GridLayout(2, 3, 30, 30));
		this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// Creation
		this.btnPrev      = UIFactory.createBtn("prev.png");
		this.btnPP        = UIFactory.createBtn("play.png");
		this.btnNext      = UIFactory.createBtn("next.png");
		this.btnRestart   = UIFactory.createBtn("restart.png");
		this.btnLoad      = UIFactory.createBtn("load.png");
		this.btnSave      = UIFactory.createBtn("save.png");

		this.chooser = new JFileChooser(new File("./saved/"));
		this.chooser.setFileFilter(new FileNameExtensionFilter(null, "cells"));

		// Listen event
		this.btnPrev   .addActionListener(this);
		this.btnPP     .addActionListener(this);
		this.btnNext   .addActionListener(this);
		this.btnRestart.addActionListener(this);
		this.btnLoad   .addActionListener(this);
		this.btnSave   .addActionListener(this);

		// Positioning
		this.add(this.btnPrev);
		this.add(this.btnPP);
		this.add(this.btnNext);
		this.add(this.btnRestart);
		this.add(this.btnLoad);
		this.add(this.btnSave);
	}


	// Methods
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();

		if      (src == this.btnPrev   ) this.ctrl.previous();
		else if (src == this.btnNext   ) this.ctrl.next();
		else if (src == this.btnRestart) this.ctrl.restart();
		else if (src == this.btnPP     ) this.ctrl.playPause();
		else if (src == this.btnSave   ) this.ctrl.save(JOptionPane.showInputDialog(null, null, "File name", JOptionPane.QUESTION_MESSAGE));
		else if (src == this.btnLoad && this.chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			this.ctrl.load(this.chooser.getSelectedFile().getAbsolutePath());
	}

	public void maj()
	{
		UIFactory.useDesign(this.btnPP, this.ctrl.isPaused() ? "play.png" : "pause.png");
	}
}
