package com.prontoitlabs.customexception.annotaion;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.prontoitlabs.customexception.domain.User;
import com.prontoitlabs.customexception.service.UserService;

public class AuthenticatedArgumentResolver implements HandlerMethodArgumentResolver {

    //  private static final Logger LOGGER = Logger.getLogger("AuthenticatedArgumentResolver");

    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Authenticated.class);
    }

    @Override
    public User resolveArgument(MethodParameter param, ModelAndViewContainer mavContainer, NativeWebRequest request, WebDataBinderFactory binderFactory) {

        Annotation[] paramAnns = param.getParameterAnnotations();
        for (Annotation annotation : paramAnns) {
            if (Authenticated.class.isInstance(annotation)) {
                Authenticated authAnnotation = (Authenticated) annotation;
                HttpServletRequest httprequest = (HttpServletRequest) request.getNativeRequest();
                String authHeaderValue = httprequest.getHeader("AUTH-TOKEN");
                User user = null;
                if (!StringUtils.isEmpty(authHeaderValue)) {
                    //          LOGGER.debug("Auth Token is" + authHeaderValue);
                    try {
                        // String userId = AuthUtils.getTokenSubject(authHeaderValue);
                        // user = userService.findOne(userId);
                        // Role role = authAnnotation.forRole();
                        // if (user.getRole().getPriority() < role.getPriority()) {
                        // throw new UserNotAuthorizedException();
                        // }
                    } catch (Exception ex) {
                        //            LOGGER.info(ex.getMessage());
                        if (authAnnotation.required()) {
                            throw ex;
                        }
                    }
                    return user;
                } else {
                    if (authAnnotation.required()) {
                        // throw new UserNotAuthorizedException();
                    }
                }
            }
        }
        return null;
    }
}
