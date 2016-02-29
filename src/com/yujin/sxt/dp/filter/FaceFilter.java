package com.yujin.sxt.dp.filter;

public class FaceFilter implements Filter{

    @Override
    public String doFilter(Request request, Response response, FilterChain chain) {
        request.req = request.req.replace(":)", "^V^");
        chain.doFilter(request, response, chain);
        response.response += "----FaceFilter()";
        return null;
    }

}
