package com.yujin.sxt.dp.filter;

public class HTMLFilter implements Filter{

    @Override
    public String doFilter(Request request, Response response, FilterChain chain) {
        request.req = request.req.replace('<', '[').replace('>', ']');
        chain.doFilter(request, response, chain);
        response.response += "----HTMLFilter()";
        return null;
    }

}
