package reg.nijg.transfer.client;

import java.io.IOException;
import java.io.Serializable;

public interface CommClient {
    	<T extends Serializable,R extends Serializable>  R send2(T t, Class<R> r) throws IOException, ClassNotFoundException;

	public  <T extends Serializable> void send3(T t);
}
