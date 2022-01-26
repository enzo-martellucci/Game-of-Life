package lifegame.view.util;

import javax.swing.*;
import java.awt.*;

public final class UIFactory
{
	private UIFactory(){}

	private static final ClassLoader LOADER = UIFactory.class.getClassLoader();

	public static JButton createBtn(String design)
	{
		JButton btn = new JButton();
		UIFactory.useDesign(btn, design);
		return btn;
	}

	public static void useDesign(JButton btn, String design)
	{
		Icon nIcon = new ImageIcon(LOADER.getResource("images/button/normal/"   + design));
		Icon pIcon = new ImageIcon(LOADER.getResource("images/button/pressed/"  + design));
		Icon rIcon = new ImageIcon(LOADER.getResource("images/button/rollover/" + design));

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
		Icon icon = new ImageIcon(LOADER.getResource("images/label/" + design));

		lbl.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		lbl.setIcon(icon);

		return lbl;
	}
}
