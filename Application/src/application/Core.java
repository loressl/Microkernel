
package application;

import interfaces.IAutenticationController;
import interfaces.ICore;
import interfaces.IPluginController;
import interfaces.IUIController;
import sun.security.jca.GetInstance;

public class Core implements ICore {

    private Core() {
        uiController = new UIController();
        pluginController = new PluginController();
        autenticationController = new AutenticationController();
        pluginController.initialize(this);
        autenticationController.initialize(this);
        uiController.initialize(this);
    }
    
    public static Core getInstance() {
    	if(instance == null)
    		instance = new Core();
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
    private IUIController uiController;
    private IPluginController pluginController;
    private IAutenticationController autenticationController;
    
}
