package reg.nijg.transfer.notify;

public interface PublishService {

	public void publishAllEvent();

	/***
	 * 通知
	 * */
	public void notifySyncEvent(StartUpEvent envent);
}
