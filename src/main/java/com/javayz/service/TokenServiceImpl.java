package com.javayz.service;

import com.javayz.entity.Response;
import com.javayz.entity.ResponseCode;
import com.javayz.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author by: Liyu
 * @ClassName: TokenServiceImpl
 * @Description: TODO token业务接口实现类
 * @Date: 2020/11/9 11:39
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Response createToken() {
        //生成uuid当作token
        String token = UUID.randomUUID().toString().replaceAll("-","");
        //将生成的token存入redis中
        redisTemplate.opsForValue().set(token,token);
        //返回正确的结果信息
        Response response=new Response(0,token.toString(),null);
        return response;
    }

    @Override
    public Response checkToken(HttpServletRequest request) {
        //从请求头中获取token
        String token=request.getHeader("token");
        if (StringUtils.isBlank(token)){
            //如果请求头token为空就从参数中获取
            token=request.getParameter("token");
            //如果都为空抛出参数异常的错误
            if (StringUtils.isBlank(token)){
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getCode().toString(),ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }
        //如果redis中不包含该token，说明token已经被删除了，抛出请求重复异常
        if (!redisTemplate.hasKey(token)){
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getCode().toString(),ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        //删除token
        Boolean del=redisTemplate.delete(token);
        //如果删除不成功（已经被其他请求删除），抛出请求重复异常
        if (!del){
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getCode().toString(),ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        return new Response(0,"校验成功",null);
    }
}
