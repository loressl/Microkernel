package interfaces;

import javax.swing.JMenuItem;

public interface IUIController {
    public boolean initialize(ICore core);

    public JMenuItem addMenuItem(String menuName, String menuItemName);
}
