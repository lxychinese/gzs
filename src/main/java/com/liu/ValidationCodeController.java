package com.liu;

import com.github.bingoohuang.patchca.color.ColorFactory;
import com.github.bingoohuang.patchca.custom.ConfigurableCaptchaService;
import com.github.bingoohuang.patchca.filter.predefined.*;
import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;
import com.github.bingoohuang.patchca.word.RandomWordFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * Created by xujb on 2016/11/21.
 */
@Controller()
@RequestMapping("/outer/validationCode")
public class ValidationCodeController {

    private static ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
    private static Random random = new Random();

    static {
//        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setHeight(50);
        cs.setColorFactory(new ColorFactory() {
            @Override
            public Color getColor(int x) {
                int[] c = new int[3];
                int i = random.nextInt(c.length);
                for (int fi = 0; fi < c.length; fi++) {
                    if (fi == i) {
                        c[fi] = random.nextInt(71);
                    } else {
                        c[fi] = random.nextInt(256);
                    }
                }
                return new Color(c[0], c[1], c[2]);
            }
        });
        RandomWordFactory wf = new RandomWordFactory();
        wf.setCharacters("123456789");
        wf.setMaxLength(4);
        wf.setMinLength(4);
        cs.setWordFactory(wf);
    }

    @RequestMapping("")
    public void validationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        switch (random.nextInt(5)) {
            case 0:
                cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
                break;
            case 1:
                cs.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
                cs.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
                cs.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
                cs.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
        }
        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession();
        }
        setResponseHeaders(response);
        String token = EncoderHelper.getChallangeAndWriteImage(cs, "png", response.getOutputStream());
        session.setAttribute("captchaToken", token);
    }

    @ResponseBody
    @RequestMapping(value = "/check", produces = "application/json;charset=UTF-8")
    public String check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String captchaToken = request.getParameter("captchaToken");

        if (StringUtils.isEmpty(captchaToken)) {
            return "{\"code\":-1}";
        }

        if (captchaToken.equalsIgnoreCase((String) request.getSession().getAttribute("captchaToken"))) {
            return "{\"code\":1}";
        }

        return "{\"code\":-1}";
    }

    protected void setResponseHeaders(HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
    }

}
