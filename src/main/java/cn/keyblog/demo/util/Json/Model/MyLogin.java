package cn.keyblog.demo.util.Json.Model;

public class MyLogin {
    String id;
    String code;
    String msg;

    public MyLogin(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
