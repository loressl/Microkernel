
package application;

import interfaces.IAutenticationController;
import interfaces.ICore;
import interfaces.IPluginController;
import interfaces.IUIController;

public class Core implements ICore {

    private Core() {}
    
    public static Core getInstance() {
    	if(instance == null) {
    		instance = new Core();
    		uiController = new UIController();
    		pluginController = new PluginController();
    		autenticationController = new AutenticationController();
    		pluginController.initialize();
    		autenticationController.initialize();
    		uiController.initialize();		
    	}
    	return instance;
    }
    
    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
    @Override
    public IAutenticationController getAutenticationController() {
    	return autenticationController;
    }
    
    private static Core instance = null;
    private static IUIController uiController;
    private static IPluginController pluginController;
    private static IAutenticationController autenticationController;
    
}
