package cn.frochy.http.constants;

public enum HttpStatusEnum {

    CONTINUE(100, "continue"),
    OK(200, "OK"),
    NOT_MODIFIED(304, "not modified"),
    NOT_FOUND(404, "not found"),
    INTERNAL_SERVER_ERROR(500, "internal server error");

    private int code;
    private String desc;

    HttpStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getHttpStatus() {
        return " " + this.getCode() + " " + this.getDesc();
    }

}
