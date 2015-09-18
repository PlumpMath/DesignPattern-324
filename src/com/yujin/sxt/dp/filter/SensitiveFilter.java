package com.yujin.sxt.dp.filter;

public class SensitiveFilter implements Filter {

    @Override
    public String doFilter(Request request, Response response, FilterChain chain) {
       request.req = request.req.replace("被就业", "就业");
       chain.doFilter(request, response, chain);
       response.response += "----SensitiveFilter()";
        return null;
    }

}
