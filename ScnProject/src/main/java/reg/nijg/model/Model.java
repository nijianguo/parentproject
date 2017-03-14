package reg.nijg.model;

import reg.nijg.transfer.client.AbsReqTransfer;
import reg.nijg.transfer.client.ReqTransferParam;

import java.math.BigDecimal;

/**
 * Created by nijianguo on 17/2/17.
 */
public class Model extends AbsReqTransfer{


    public String name;
    public int  age;
    public BigDecimal intel;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getIntel() {
        return intel;
    }

    public void setIntel(BigDecimal intel) {
        this.intel = intel;
    }
}
