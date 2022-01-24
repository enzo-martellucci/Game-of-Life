package lifegame;

import lifegame.model.Grid;
import lifegame.view.View;

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
		this.loop   = new Loop(this);
		this.paused = true;
		new Thread(this.loop).start();

		this.grid = new Grid();
		this.view = new View(this, this.grid);
	}


	// Accessors
	public boolean isPaused(){ return this.paused; }


	// Methods
	synchronized void loopMaj()
	{
		if (this.paused)
			try{ this.wait(); } catch (Exception e){ e.printStackTrace(); }
		this.grid.next();
		this.view.maj();
	}

	public synchronized void playPause()
	{
		this.paused = !this.paused;
		this.view.majAction();
		this.notify();
	}

	public void next()
	{
		if (!this.paused)
			this.playPause();
		this.grid.next();
		this.view.maj();
	}

	public void previous()
	{
		if (!this.paused)
			this.playPause();
		this.grid.previous();
		this.view.maj();
	}

	public void restart()
	{
		if (!this.paused)
			this.playPause();
		this.grid.restart();
		this.view.majDimension();
		this.view.maj();
	}

	public void load(String file)
	{
		if (!this.paused)
			this.playPause();
		this.grid.load(file);
		this.view.majDimension();
		this.view.maj();
	}

	public void save(String file)
	{
		if (file == null)
			return;
		this.grid.save(file);
	}

	public void random()
	{
		if (!this.paused)
			this.playPause();
		this.grid.random();
		this.view.maj();
	}

	public void randomS()
	{
		if (!this.paused)
			this.playPause();
		this.grid.randomS();
		this.view.maj();
	}

	public void randomDS()
	{
		if (!this.paused)
			this.playPause();
		this.grid.randomDS();
		this.view.maj();
	}

	public void changeSpeed(int value)
	{
		this.loop.setSpeed(value);
	}


	// Main
	public static void main(String[] args)
	{
		new Controller();
	}
}
