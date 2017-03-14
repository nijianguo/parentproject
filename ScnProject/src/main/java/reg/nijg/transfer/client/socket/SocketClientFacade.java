package reg.nijg.transfer.client.socket;

import reg.nijg.transfer.client.AbsClientFacade;
import reg.nijg.transfer.client.CommClient;
import reg.nijg.transfer.client.ReqTransferParam;

/**
 * 要保证线程安全
 * **/
public class SocketClientFacade  extends AbsClientFacade{

	public SocketClientFacade(CommClient commClient) {
		super(commClient);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	protected void encode(ReqTransferParam param) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void decode(ReqTransferParam param) {
//		// TODO Auto-generated method stub
//
//	}

}
