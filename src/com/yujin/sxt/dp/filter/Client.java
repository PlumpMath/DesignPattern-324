package com.yujin.sxt.dp.filter;

public class Client {

    public static void main(String[] args) {
        String msg = "大家好:)，<script>，敏感，被就业，网络授课没感觉，因为看不见大家伙儿";
        Request request = new Request();
        request.setReq(msg);
        Response response = new Response();
        response.setResponse("--->response");
        Filter f1 = new HTMLFilter();
        Filter f2 = new FaceFilter();
        Filter f3 = new SensitiveFilter();
        FilterChain fc = new FilterChain();
        fc.addFilter(f1);
        fc.addFilter(f2);
        fc.addFilter(f3);
        
        fc.doFilter(request, response, fc);
        System.out.println(request.req);
        System.out.println(response.response);
    }
}
