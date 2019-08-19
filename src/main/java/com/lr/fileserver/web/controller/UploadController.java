package com.lr.fileserver.web.controller;

import com.lr.common.base.ResultResponse;
import com.lr.common.model.BlockedQ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2019年08月05日
 */
@RequestMapping("/upload")
@RestController
public class UploadController {
    BlockedQ<Integer> blockedQ = BlockedQ.getIns();

    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody
    public ResultResponse Test(){
        while(true){
            blockedQ.doPoll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        return ResultResponse.createBySuccess();
    }
}
