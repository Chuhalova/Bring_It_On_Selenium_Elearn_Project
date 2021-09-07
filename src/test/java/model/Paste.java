package model;

public class Paste {
    private String code;
    private String title;
    private int expirationTime;

    public Paste(String code, String title, int expirationTime) {
        this.code = code;
        this.title = title;
        this.expirationTime = expirationTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(int expirationTime) {
        this.expirationTime = expirationTime;
    }
}
