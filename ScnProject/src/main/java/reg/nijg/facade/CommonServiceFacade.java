package reg.nijg.facade;

import javax.jws.WebParam;
import javax.jws.WebService;

import reg.nijg.annotation.TRANS_TYPE;
import reg.nijg.annotation.TransTypeEnum;
import reg.nijg.model.Model;


/**
 * 定义公共方法
 * 
 * **/
@WebService
public interface CommonServiceFacade {

	/**
	 * 测试方法
	 * **/
	@TRANS_TYPE(type=TransTypeEnum.RESTFUL)
	public String helloWorld(@WebParam String param);



	/***
	 * 测试socket通讯
	 * */
	@TRANS_TYPE(type=TransTypeEnum.SOCKET)
	public String helloSocket(Model param);
	
}
