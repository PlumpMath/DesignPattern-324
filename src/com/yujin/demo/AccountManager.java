package com.yujin.demo;

public interface AccountManager {

    User register(String name, String pwd, String email) throws UserExistException;
    User login(String name, String pwd) throws NameOrPwdException;
}
