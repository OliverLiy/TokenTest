package com.javayz.service;

import com.javayz.entity.Response;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author by: Liyu
 * @ClassName: TokenService
 * @Description: TODO token业务接口
 * @Date: 2020/11/9 11:39
 */
@Service
public interface TokenService {
    public Response createToken();
    public Response checkToken(HttpServletRequest request);
}
