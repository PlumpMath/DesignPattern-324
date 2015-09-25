package com.yujin.demo;

public class AccountManageTest {

    public static void main(String[] args) {
        AccountManager accountMgr = new AccountManagerImpl();
        try {
            accountMgr.register("林志玲", "123456", "linzhiling@lakala.com");
            accountMgr.register("黄勃", "123456", "linzhiling@lakala.com");
            accountMgr.register("周兴迟", "123456", "linzhiling@lakala.com");
            accountMgr.register("猪八戒", "123456", "linzhiling@lakala.com");
            accountMgr.register("唐三藏", "123456", "linzhiling@lakala.com");
        } catch (UserExistException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
            User u = accountMgr.login("林志玲", "123456");
        } catch (NameOrPwdException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("tom".hashCode());
        System.out.println("jerry".hashCode());
        System.out.println("john".hashCode());
        System.out.println("robin".hashCode());
        System.out.println("gg".hashCode());
        System.out.println("mm".hashCode());
        System.out.println("dd".hashCode());
        System.out.println("=====================");
        System.out.println("tom".hashCode()%10);
        System.out.println("jerry".hashCode()%10);
        System.out.println("john".hashCode()%10);
        System.out.println("robin".hashCode()%10);
        System.out.println("gg".hashCode()%10);
        System.out.println("mm".hashCode()%10);
        System.out.println("dd".hashCode()%10);
    }
}
