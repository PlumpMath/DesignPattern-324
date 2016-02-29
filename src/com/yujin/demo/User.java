package com.yujin.demo;

public class User {

    private String userName;
    private int userId;
    private String password;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class UserExistException extends Exception {

    public UserExistException() {
        super();
        
    }

    public UserExistException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
        
    }

    public UserExistException(String message) {
        super(message);
        
    }

    public UserExistException(Throwable cause) {
        super(cause);
        
    }
    
}

class NameOrPwdException extends Exception {

    public NameOrPwdException() {
        super();
        
    }

    public NameOrPwdException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        
    }

    public NameOrPwdException(String message, Throwable cause) {
        super(message, cause);
        
    }

    public NameOrPwdException(String message) {
        super(message);
        
    }

    public NameOrPwdException(Throwable cause) {
        super(cause);
        
    }

}
