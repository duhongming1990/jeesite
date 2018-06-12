package com.thinkgem.jeesite.modules.sys.web;

import com.baidu.ueditor.ActionEnter;
import com.thinkgem.jeesite.common.utils.SystemPath;
import com.thinkgem.jeesite.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/6/12 14:18
 */
@Controller
@RequestMapping(value = "${adminPath}/ueditor")
public class UEditorController extends BaseController {

    @RequestMapping(value = "ueditorapi")
    public @ResponseBody String ueditorapi(HttpServletRequest request,
                      HttpServletResponse response)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        String rootPath = SystemPath.getSysPath();
        String s = new ActionEnter(request,rootPath).exec();
        System.out.println("s = " + s);
        return s;
    }
}