package com.yujin.demo;

public interface MyCookiePolicy {
    
    public static final MyCookiePolicy var1 = new MyCookiePolicy() {

        @Override
        public boolean shouldAccept(String uri, String cookie) {
            // TODO Auto-generated method stub
            System.out.println("var1 shouldAccept");
            System.out.println(uri + " " + cookie);
            return true;
        }
    };
    
    public static final MyCookiePolicy var2 = new MyCookiePolicy() {
        
        @Override
        public boolean shouldAccept(String uri, String cookie) {
            // TODO Auto-generated method stub
            System.out.println("var2 shouldAccept");
            System.out.println(uri + " " + cookie);
            return false;
        }
    };
    
    
    boolean shouldAccept(String uri, String cookie);
}
