
package filenewopenplugin;

import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IUIController;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

public class FileNewOpenPlugin implements IPlugin {

	@Override
	public boolean initialize(ICore core) {
		IUIController uiController = core.getUIController();				
		
		JMenuItem fileNewItem = uiController.addMenuItem("File", "New");
		fileNewItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					String typeExtension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
					core.getPluginController().verifyFileExtension(typeExtension);
					System.out.println("\nDocumento: " + file.getName() + ".\n");
				} else {
					System.out.println("\nAbertura de arquivo cancela.");
				}	
			}
		});
		
        JMenuItem fileOpenItem = uiController.addMenuItem("File", "Open");
        fileOpenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Voce clicou no File->Open");
            }
        });  

		return true;
	}

}
