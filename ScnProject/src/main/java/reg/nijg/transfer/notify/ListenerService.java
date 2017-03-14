package reg.nijg.transfer.notify;

import java.util.List;

public interface ListenerService {

	public void registListener(StartUpEventListener listener);
	
	public void removeListener(StartUpEventListener listener);
    
	public List<StartUpEventListener> getAllListener();

}
