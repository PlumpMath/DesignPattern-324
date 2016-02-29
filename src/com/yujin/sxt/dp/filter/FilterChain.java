package com.yujin.sxt.dp.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{

    List<Filter> filters = new ArrayList<Filter>();
    int index = 0;
    
    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }
    
    @Override
    public String doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size())  return null;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request, response, chain);
        return null;
    }
    
}
