package com.yujin.demo;

import java.util.HashMap;
import java.util.Map;

public class AccountManagerImpl implements AccountManager{

    private Map<String, User> map = new HashMap<String, User>();
    private int id = 0;
    @Override
    public User register(String name, String pwd, String email) throws UserExistException {
        if (null != map.get(name)) {
            throw new UserExistException("该用户已存在!");
        }
        User user = new User();
        user.setUserId(id++);
        user.setUserName(name);
        user.setPassword(pwd);
        user.setEmail(email);
        map.put(user.getUserName(), user);
        return null;
    }

    @Override
    public User login(String name, String pwd) throws NameOrPwdException {
        if (map.get(name) ==  null) {
            throw new NameOrPwdException("该用户不存在");
        }
        if (!map.get(name).getPassword().equals(pwd)) {
            throw new NameOrPwdException("密码错误");
        }
        System.out.println("欢迎光临");
        return null;
    }

}
