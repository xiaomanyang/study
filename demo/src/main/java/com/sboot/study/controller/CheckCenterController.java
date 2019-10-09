package com.sboot.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.sboot.study.server.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor wcl
 * @create 2019-10-09 17:50
 */
@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/index");
        mav.addObject("cid", cid);
        return mav;
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public JSONObject pushToWeb(@PathVariable String cid, String message) {
        JSONObject jsonObject = new JSONObject();
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("status", "error");
            return jsonObject;
        }
        jsonObject.put("status", "success");
        return jsonObject;
    }
}
