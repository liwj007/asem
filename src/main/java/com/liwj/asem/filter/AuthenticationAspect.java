package com.liwj.asem.filter;


import com.liwj.asem.annotation.Rights;
import com.liwj.asem.annotation.UserRight;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;
import com.liwj.asem.service.IUserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liwj0 on 2017/7/28.
 */
@Aspect   //定义一个切面
@Configuration
public class AuthenticationAspect {

    @Autowired
    private IUserService userService;


    @Pointcut("execution(* com.liwj.asem.controller..*.*(..))")
    public void executeService() {

    }

    @Around("executeService()")
    public Object doAuthentication(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();

        if (targetMethod.getName().equals("login")) {
            return joinPoint.proceed();
        }

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String token = request.getParameter("token");

        if (token != null && !"".equals(token)) {

            User user = userService.getUserByToken(token);
            if (user == null) {
                throw new WSPException(ErrorInfo.NO_LOGIN);
            }

            UserRight userRight = targetMethod.getAnnotation(UserRight.class);
            if (userRight == null) {
                return joinPoint.proceed();
            }


            Date now = new Date();
            if (now.getTime() > user.getExpire()) {
                throw new WSPException(ErrorInfo.TOKEN_EXP);
            }

            if (user != null) {
                if (userRight.authorities().length > 0) {
                    int[] authorities = userRight.authorities();
                    Set<Integer> authSet = new HashSet<>();
                    for (int authority : authorities) {
                        authSet.add(authority);
                    }


                    Integer role = user.getUserType();


                    if (role != null) {
                        if (authSet.contains(role)) {
                            return joinPoint.proceed();
                        }
                    }
                    throw new WSPException(ErrorInfo.NO_RIGHT);
                }
                return joinPoint.proceed();
            }
        } else {
            throw new WSPException(ErrorInfo.NO_LOGIN);
        }

        throw new WSPException(ErrorInfo.NO_RIGHT);

    }
}



