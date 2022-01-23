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
		System.out.println("Restart");
	}

	public void load()
	{
		System.out.println("Load");
	}

	public void save(String name)
	{
		if (name == null)
			return;
		this.grid.save(name);
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


	// Main
	public static void main(String[] args)
	{
		new Controller();
	}
}
