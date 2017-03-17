package reg.nijg.transfer.client;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.channels.Selector;

/***
 * <li> nijg</li>
 * 
 * **/
public abstract class AbsClientFacade {


	private CommClient commClient;
	
	public AbsClientFacade(CommClient commClient) {
		super();
		this.commClient = commClient;
	}



	public Object  execute(AbsReqTransfer req)throws ClassNotFoundException, IOException{
		if("void".equals(req.getRespClassName())) {
			commClient.send2(req, req.getRespClass());
			return null;
		}else{
			return commClient.send2(req, req.getRespClass());
		}
	}





}
