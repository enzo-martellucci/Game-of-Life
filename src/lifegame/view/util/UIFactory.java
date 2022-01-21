package lifegame.view.util;

import javax.swing.*;

public final class UIFactory
{
	private UIFactory(){}

	private static final String IMG_PATH = "./resources/images/";

	public static JButton createBtn(String img)
	{
		JButton btn = new JButton();
		btn.setBorderPainted    (false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted     (false);

		btn.setIcon        (new ImageIcon(IMG_PATH + "normal/"   + img));
		btn.setPressedIcon (new ImageIcon(IMG_PATH + "pressed/"  + img));
		btn.setRolloverIcon(new ImageIcon(IMG_PATH + "rollover/" + img));

		return btn;
	}
}
