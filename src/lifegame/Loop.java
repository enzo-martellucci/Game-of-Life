package lifegame;

public class Loop implements Runnable
{
	// Attributes
	private Controller ctrl;

	private int delay;
	private boolean running;


	// Constructor
	Loop(Controller ctrl)
	{
		this.ctrl = ctrl;

		this.delay = 500;
		this.running = true;
	}


	// Methods
	public void run()
	{
		while (this.running)
		{
			System.out.println("Loop");
			try
			{
				this.ctrl.loopMaj();
				Thread.sleep(this.delay);
			}
			catch (Exception e){ e.printStackTrace(); }
		}
	}

	void setDelay(int delay)
	{
		this.delay = delay;
	}

	void stop()
	{
		this.running = false;
	}
}
