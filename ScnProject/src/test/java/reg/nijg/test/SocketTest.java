package reg.nijg.test;

import reg.nijg.facade.CommonServiceFacade;
import reg.nijg.model.Model;
import reg.nijg.transfer.proxy.SocketClientProxy;

/**
 * 测试类
 * **/
public class SocketTest {

	/**
	 * ObjectInputStream   ois = new ObjectInputStream(socket.getInputStream());
	 * 
	 * **/
	public static void main(String[] args){
		CommonServiceFacade service =(CommonServiceFacade)SocketClientProxy.getInstance();
		Model model = new Model();
		model.setAge(11123);
		model.setName("nijg");
		service.helloSocket(model);

	}
}
