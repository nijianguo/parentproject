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

//	private DispatchServlet servlet;
 	
	private CommClient commClient;
	
	public AbsClientFacade(CommClient commClient) {
		super();
		this.commClient = commClient;
	}



	public final void  execute(AbsReqTransfer req)throws ClassNotFoundException, IOException{
//		commClient.send2(req);

		Method rtnMethod=null;
		Class clazz = Class.forName(req.getClassName());
//		Method method = clazz.getDeclaredMethod(req.getMethodName());
		try {
			rtnMethod= clazz.getDeclaredMethod(req.getMethodName(),reg.nijg.model.Model.class);
			if(req.getRespClassName()==null){
				 commClient.send2(req, req.getRespClass());
			}

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}


		Class rtnclazz = rtnMethod.getReturnType();
		commClient.send2(req,rtnclazz);
	}





}
