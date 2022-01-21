package lifegame;

import lifegame.model.Grid;
import lifegame.view.View;

import javax.swing.*;

public class Controller
{
	// Attributes
	private Grid grid;
	private View view;

	private Loop loop;
	private boolean paused;


	// Constructor
	private Controller()
	{
		this.grid = new Grid();
		this.view = new View(this, this.grid);

		this.loop   = new Loop(this);
		this.paused = true;

		new Thread(this.loop).start();
	}


	// Accessors
	public boolean isPaused(){ return this.paused; }


	// Methods
	synchronized void loopMaj()
	{
		if (this.paused)
			try{ this.wait(); } catch (Exception e){ e.printStackTrace(); }
		this.next();
	}

	public synchronized  void playPause()
	{
		this.paused = !this.paused;
		this.notify();
	}

	public void next()
	{
		this.grid.next();
		this.view.maj();
	}

	public void previous()
	{
		System.out.println("Previous");
	}

	public void restart()
	{
		System.out.println("Restart");
	}

	public void load()
	{
		System.out.println("Load");
	}

	public void save()
	{
		System.out.println("Save");
	}


	// Main
	public static void main(String[] args)
	{
		new Controller();
	}
}
