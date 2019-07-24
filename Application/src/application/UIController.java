
package application;

import interfaces.IDocumentFactory;
import interfaces.IUIController;

import java.io.File;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UIController implements IUIController {

	@Override
	public boolean initialize() {
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		
		JMenuItem fileNewItem = addMenuItem("File", "Open");
		fileNewItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					String typeExtension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
					verifyExtension(typeExtension);
					System.out.println("\nDocumento: " + file.getName() + ".\n");
				} else {
					System.out.println("\nAbertura de arquivo cancela.");
				}	
			}
		});
		
		return true;
	}

	@Override
	public JMenuItem addMenuItem(String menuName, String menuItemName) {
		JMenu myMenu = null;
		JMenuBar myMenuBar = mainWindow.getJMenuBar();
		for (int i = 0; i < myMenuBar.getMenuCount(); ++i) {
			if (myMenuBar.getMenu(i).getText().equals(menuName))
				myMenu = myMenuBar.getMenu(i);
		}

		if (myMenu == null) {
			myMenu = new JMenu(menuName);
			myMenuBar.add(myMenu);
		} else {
			for (int i = 0; i < myMenu.getItemCount(); ++i)
				if (myMenu.getItem(i).getText().equals(menuItemName))
					return null;
		}

		JMenuItem myMenuItem = new JMenuItem(menuItemName);
		myMenu.add(myMenuItem);

		mainWindow.pack();

		return myMenuItem;
	}
	
	private void verifyExtension(String typeExtension) {
		boolean foundExtension = false;
		List<IDocumentFactory> loadedPluginsByType = Core.getInstance().getPluginController().getLoadedPluginsByType(IDocumentFactory.class);
		for (IDocumentFactory documentFactory : loadedPluginsByType) {
			StringTokenizer extensions = new StringTokenizer(documentFactory.getSupportedExtensions(), "|");
			while (extensions.hasMoreTokens()) {
				if (typeExtension.equals(extensions.nextToken())) {
					documentFactory.getDocumentEditor().open();
					documentFactory.getDocumentValidator().validate();
					documentFactory.getDocumentSerializer().load();
					documentFactory.getDocumentSerializer().save();
					
					foundExtension = true;
					break;
				}
			}
		}

		if (!foundExtension)
			System.out.println("\nN�o h� suporte para a extens�o de arquivo " + typeExtension + ".");
		
	}

	private MainWindow mainWindow;
}
