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
		this.ctrl    = ctrl;
		this.running = true;
	}


	// Methods
	public void run()
	{
		while (this.running)
		{
			try
			{
				this.ctrl.loopMaj();
				Thread.sleep(this.delay);
			}
			catch (Exception e){ e.printStackTrace(); }
		}
	}

	void setSpeed(int value)
	{
		double tmp;

		if   (value <=50) tmp = 100 + ((50  - value) / 50.0) * 900;
		else              tmp = 1   + ((100 - value) / 50.0) * 99;

		this.delay = (int) tmp;
	}

	void stop()
	{
		this.running = false;
	}
}
