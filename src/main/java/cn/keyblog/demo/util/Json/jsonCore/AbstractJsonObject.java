package cn.keyblog.demo.util.Json.jsonCore;


import cn.keyblog.demo.util.Json.status.StatusObject;

public class AbstractJsonObject {

    private String code;
    //
    private String msg;

    private long number=0;

    private Long time = System.currentTimeMillis();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * @return the time
     */
    public Long getTime() {
        return time;
    }

    /**
     * @param time
     *            the time to set
     */
    public void setTime(Long time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setContent(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setStatusObject(StatusObject statusObject) {
        this.code = statusObject.getCode();
        this.msg = statusObject.getMsg();
    }
}


