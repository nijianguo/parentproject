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
	public static void main(String[] args) throws NoSuchMethodException {
		CommonServiceFacade service =(CommonServiceFacade)SocketClientProxy.getInstance();
		Model model = new Model();
		model.setAge(11123);
		model.setName("nijg");
		String a = service.helloSocket(model);
//System.out.println(SocketTest.class.getDeclaredMethod("test").getReturnType());
		System.out.print(a);

	}


	public  void test(){
		System.out.println("aaaa");
	}
}
