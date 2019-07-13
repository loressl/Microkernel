package interfaces;

import java.util.List;

public interface IPluginController {
	public boolean initialize(ICore core);
	public List<IPlugin> getLoadedPlugins();
	public <T> List<T> getLoadedPluginsByType(Class<T> interfaceFactory);
}