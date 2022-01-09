package com.item.common.controller;

import com.item.common.common.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-15
 */

@Slf4j
@RestController
public abstract class ApiBaseController {
    void handler(HttpServletRequest request, HttpServletResponse response) {
        try {
            process(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) {
        buildContext(request, response);
    }

    private void buildContext(HttpServletRequest request, HttpServletResponse response) {
        BaseContext baseContext = BaseContext.currentContext();
        try {
            ServletInputStream inputStream = request.getInputStream();
            byte[] bytes = IOUtils.readExactlyNBytes(inputStream, 1);
        } catch (IOException e) {
            log.error("");
        }
    }
}
