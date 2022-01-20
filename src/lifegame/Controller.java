package lifegame;

import lifegame.model.Grid;
import lifegame.view.View;

public class Controller
{
	// Attributes
	private Grid grid;
	private View view;


	// Constructor
	private Controller()
	{
		this.grid = new Grid();
		this.view = new View(this, this.grid);

		this.view.maj();
		for (int i = 0; i < 10000; i++)
		{
			try
			{
				Thread.sleep(100);
			}
			catch (Exception e){ e.printStackTrace(); }
			this.grid.next();
			this.view.maj();
		}
	}


	// Main
	public static void main(String[] args)
	{
		new Controller();
	}
}
