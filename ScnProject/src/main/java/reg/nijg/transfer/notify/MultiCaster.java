package reg.nijg.transfer.notify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 定义事件源
 * **/
public final class MultiCaster  implements ListenerService,PublishService{

	private  ConcurrentLinkedQueue<StartUpEventListener> listeners;
	
	@Override
	public void registListener(StartUpEventListener listener) {
		// TODO Auto-generated method stub
		listeners.add(listener);
	}

	@Override
	public void removeListener(StartUpEventListener listener) {
		// TODO Auto-generated method stub
		
		listeners.remove(listener);
	   	
	}

	@Override
	public List<StartUpEventListener> getAllListener() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void publishAllEvent() {
		// TODO Auto-generated method stub
	}

	@Override
	public void notifySyncEvent(final StartUpEvent envent) {
		// TODO Auto-generated method stub
		
//	  异步处理加载问题 已经超出了 观察者模式
//	 可以在EVENT 里面继续封装一部分自定义代码
     for(final StartUpEventListener listener :listeners){
    	 Executors.newSingleThreadExecutor().submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				listener.handleEvent(envent);
			}
		});
    	 
     }
		
		
	}

	 

	
	
	
	
	
	
	
	
}
