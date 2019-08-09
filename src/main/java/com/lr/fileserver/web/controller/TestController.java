package com.lr.fileserver.web.controller;

import com.lr.common.base.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2019年08月02日
 */
@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody
    public ResultResponse Test(){
        return ResultResponse.createBySuccess();
    }

    @RequestMapping(value="/log",method=RequestMethod.GET)
    @ResponseBody
//    @RequestLog(level = "error")
    public ResultResponse log(){
        return ResultResponse.createBySuccess();
    }

}
