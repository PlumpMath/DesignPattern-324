package com.yujin.sxt.dp.filter;

public interface Filter {

    public String doFilter(Request requset, Response response, FilterChain chain);
}
