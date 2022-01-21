package lifegame.view.util;

import javax.swing.*;

public final class UIFactory
{
	private UIFactory(){}

	private static final String IMG_PATH = "./resources/images/";

	public static JButton createBtn(String design)
	{
		JButton btn = new JButton();
		UIFactory.useDesign(btn, design);
		return btn;
	}

	public static void useDesign(JButton btn, String design)
	{
		btn.setBorderPainted    (false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted     (false);

		btn.setIcon        (new ImageIcon(IMG_PATH + "normal/"   + design));
		btn.setPressedIcon (new ImageIcon(IMG_PATH + "pressed/"  + design));
		btn.setRolloverIcon(new ImageIcon(IMG_PATH + "rollover/" + design));
	}
}
