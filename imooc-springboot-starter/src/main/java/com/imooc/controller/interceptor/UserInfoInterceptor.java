package com.imooc.controller.interceptor;

import com.imooc.exception.GraceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    /**
     * 拦截请求，访问controller之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String userId = request.getHeader("userId");
        String userToken = request.getHeader("userToken");

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(userToken)) {
            log.error("用户校验不通过，信息不完整");
            GraceException.display("用户校验不通过，信息不完整");
            return false;
        }

        // 假设真实的用户id是1001，用户token是abcxyz
        if (!userId.equalsIgnoreCase("1001")
                || !userToken.equalsIgnoreCase("abcxyz")) {
            log.error("用户权限不通过");
            GraceException.display("用户权限不通过");
            return false;
        }

        /**
         * false: 请求被拦截
         * true: 请求放行，可以继续访问后面的controller
         */
        return true;
    }

    /**
     * 请求访问到controller之后，渲染视图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 请求访问到controller之后，渲染视图之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
