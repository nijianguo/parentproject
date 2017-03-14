package reg.nijg.transfer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import reg.nijg.annotation.TRANS_TYPE;
import reg.nijg.annotation.TransTypeEnum;
import reg.nijg.facade.CommonServiceFacade;
import reg.nijg.transfer.client.AbsReqTransfer;
import reg.nijg.transfer.client.SocketClient;
import reg.nijg.transfer.client.socket.SocketClientFacade;

public class SocketClientProxy {



	public static Object getInstance(){
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
//				return method.invoke(proxy, args);
				if(method.isAnnotationPresent(TRANS_TYPE.class)){
				    TRANS_TYPE type= method.getAnnotation(TRANS_TYPE.class);
					if(type.type().equals(TransTypeEnum.SOCKET)){
					    SocketClientFacade facade =  new SocketClientFacade(new SocketClient());
//						facade.execute(new ReqTransferParam());
						if(args!=null&&args.length>0){
							//判断请求参数是否继承ReqTransferParam
							if(!AbsReqTransfer.class.isInstance(args[0])){
							 throw new RuntimeException("请求参数类型 不匹配  request parameter is not implement ReqTransferParam");
							}
//							System.out.println("客户端请求参数为："+args[0].toString());
//							处理前置请求
							signMethodParam(AbsReqTransfer.class.cast(args[0]),method,proxy);
							facade.execute((AbsReqTransfer) args[0]);
						}

					}else{
					throw new  RuntimeException("type do not match parameter ..... ");	
					}
				}
				return null;
			}
		};
		Object delgate = Proxy.newProxyInstance(SocketClientProxy.class.getClassLoader(),new Class[]{CommonServiceFacade.class}, handler);
		return delgate;
	}



		public static void signMethodParam(AbsReqTransfer req,Method method,Object obj){
		req.setClassName(obj.getClass().getName());
		req.setMethodName(method.getName());
		req.setReqClassName(req.getClass().getName());
		req.setRespClassName(method.getReturnType().getName());
		req.setRespClass(method.getReturnType());
		System.out.println("signMethodParam is tostring value:"+req.toString());


//
	}
	
}


