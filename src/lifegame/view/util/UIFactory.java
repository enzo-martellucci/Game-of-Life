package lifegame.view.util;

import javax.swing.*;
import java.awt.*;

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
		Icon nIcon = new ImageIcon(IMG_PATH + "button/normal/"   + design);
		Icon pIcon = new ImageIcon(IMG_PATH + "button/pressed/"  + design);
		Icon rIcon = new ImageIcon(IMG_PATH + "button/rollover/" + design);

		btn.setPreferredSize(new Dimension(nIcon.getIconWidth(), nIcon.getIconHeight()));

		btn.setBorderPainted    (false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted     (false);

		btn.setIcon        (nIcon);
		btn.setPressedIcon (pIcon);
		btn.setRolloverIcon(rIcon);
	}

	public static JLabel createLbl(String design)
	{
		JLabel lbl = new JLabel();
		Icon icon = new ImageIcon(IMG_PATH + "label/" + design);

		lbl.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		lbl.setIcon(icon);

		return lbl;
	}
}
