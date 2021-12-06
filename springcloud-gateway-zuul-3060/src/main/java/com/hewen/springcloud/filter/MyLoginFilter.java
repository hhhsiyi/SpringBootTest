//package com.hewen.springcloud.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
//import org.springframework.http.HttpStatus;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 2021/12/6
// * Hewen
// * 云想衣裳花想容，春风拂槛露华浓
// * 最是人间留不住，朱颜辞镜花辞树
// */
//public class MyLoginFilter extends ZuulFilter {
//    @Override
//    public String filterType() {
//        return FilterConstants.PRE_TYPE; //定义为前置过滤器
//    }
//
//    @Override
//    public int filterOrder() {
//        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1; //在处理请求头之前进行拦截
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        //获取请求上下文,此作用域范围:从请求到达zuul一直到路由结束后返回给客户端这个完整流程.但是它不会存在微服务内,只存在zuul中
//        //获取request
//        //获取请求参数
//        //判断是否存在
//        //不存在,未登录,进行拦截
//        RequestContext currentContext = RequestContext.getCurrentContext();
//
//        HttpServletRequest request = currentContext.getRequest();
//
//        String token = request.getParameter("access-token");
//
//        if (StringUtils.isBlank(token))
//        {
//            currentContext.setSendZuulResponse(false);
//            currentContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
//        }
//
//        return null;
//    }
//}
