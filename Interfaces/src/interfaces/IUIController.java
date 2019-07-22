package interfaces;

import javax.swing.JMenuItem;

public interface IUIController {
    public boolean initialize();

    public JMenuItem addMenuItem(String menuName, String menuItemName);
}
