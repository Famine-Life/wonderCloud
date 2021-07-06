package com.wonder.common.base;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wonder.common.exception.BusinessException;
import com.wonder.common.exception.ExceptionGlobal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@CrossOrigin
public abstract class SuperRest extends ExceptionGlobal {

    public SuperRest() {
    }

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    protected String getToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new BusinessException("token is not found");
        } else {
            return token;
        }
    }

    protected String getToken() throws Exception {
        return this.getToken(this.getRequest());
    }

}
