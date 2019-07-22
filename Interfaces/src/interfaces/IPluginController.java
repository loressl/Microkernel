package interfaces;

import java.util.List;

public interface IPluginController {
	public boolean initialize();
	public List<IPlugin> getLoadedPlugins();
	public <T> List<T> getLoadedPluginsByType(Class<T> interfaceFactory);
}