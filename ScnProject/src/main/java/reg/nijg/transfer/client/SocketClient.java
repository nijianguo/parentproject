package reg.nijg.transfer.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;

/***
 * 根据socket生成固定格式报文。
 * 通过报文转换协议，转换为二进制字符串
 * 
 * */
public class SocketClient implements CommClient {

	@Override
	public <T extends Serializable, R extends Serializable> R send2(T t, Class<R> r) throws IOException, ClassNotFoundException {
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress("127.0.0.1",9000));
		socket.setSoTimeout(300000);
		ObjectOutputStream	bos = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois = null;
		try{
			System.out.println("客户端发送对象为t"+t);
			bos.writeObject(t);
			bos.flush();
			socket.shutdownOutput();
			if(r!=null) {
				ois = new ObjectInputStream(socket.getInputStream());
				Object rtnobj = ois.readObject();
				return r.cast(rtnobj);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			bos.close();
//			ois.close();
			if(socket!=null&&!socket.isClosed()){
				socket.close();
			}
		}
		return null;
	}

	/**
	 * 
	 *同步方法发送报文 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * **/
//	@SuppressWarnings(value="unchecked")
	/*public <T extends Serializable, R extends Serializable> R send2(T t, R r) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",9000));
        socket.setSoTimeout(300000);
	    ObjectOutputStream	bos = new ObjectOutputStream(socket.getOutputStream());
	    ObjectInputStream ois = null;
		try{
			System.out.println("客户端发送对象为t"+t);
			bos.writeObject(t);
			bos.flush();
			socket.shutdownOutput();
			ois = new ObjectInputStream(socket.getInputStream());
			r=(R)ois.readObject();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			bos.close();
//			ois.close();
			if(socket!=null&&!socket.isClosed()){
				socket.close();
			}
		}
		return r;
		
	}*/


	@Override
	public <T extends Serializable> void send3(T t) {

	}


}	
