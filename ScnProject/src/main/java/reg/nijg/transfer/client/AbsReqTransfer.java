package reg.nijg.transfer.client;



/***
 * 封装请求信息
 *
 * **/
public abstract class AbsReqTransfer implements java.io.Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /***
     *  请求代理信息
     *
     * */
    private String className;

    private String methodName;

    /****
     *请求和返回信息
     * */
    private String reqClassName;

    private String respClassName;


    private Class respClass;

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReqClassName() {
        return reqClassName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClassName() {
        return className;
    }

    public void setReqClassName(String reqClassName) {
        this.reqClassName = reqClassName;
    }

    public String getRespClassName() {
        return respClassName;
    }

    public void setRespClassName(String respClassName) {
        this.respClassName = respClassName;
    }


    public Class getRespClass() {
        return respClass;
    }

    public void setRespClass(Class respClass) {
        this.respClass = respClass;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AbsReqTransfer{");
        sb.append("className='").append(className).append('\'');
        sb.append(", methodName='").append(methodName).append('\'');
        sb.append(", reqClassName='").append(reqClassName).append('\'');
        sb.append(", respClassName='").append(respClassName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
