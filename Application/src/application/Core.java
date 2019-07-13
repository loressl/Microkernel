
package application;

import interfaces.IAutenticationController;
import interfaces.ICore;
import interfaces.IPluginController;
import interfaces.IUIController;

public class Core implements ICore {

    public Core() {
        uiController = new UIController();
        pluginController = new PluginController();
        autenticationController = new AutenticationController();
        pluginController.initialize(this);
        autenticationController.initialize(this);
        uiController.initialize(this);
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
    
    private IUIController uiController;
    private IPluginController pluginController;
    private IAutenticationController autenticationController;
    
}
