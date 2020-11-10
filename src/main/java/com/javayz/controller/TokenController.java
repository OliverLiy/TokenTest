package com.javayz.controller;

import com.javayz.entity.Response;
import com.javayz.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author by: Liyu
 * @ClassName: TokenController
 * @Description: TODO  controller，生成token以及验证token
 * @Date: 2020/11/9 17:40
 */

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @GetMapping
    public Response token(){
        return tokenService.createToken();
    }

    @PostMapping("checktoken")
    public Response checktoken(HttpServletRequest request){
        return tokenService.checkToken(request);
    }
}
