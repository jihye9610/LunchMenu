package com.widetns.lunchProject.lunchProject.kakao;

import com.widetns.lunchProject.lunchProject.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class KakaoController {

    @Autowired
    KakaoServiceImpl ks;

    @GetMapping ("/kakao/SignPage")
    public String kakaoLoginGo(@RequestParam(value = "code", required = false) String code) {


        return "kakao/kakaoLoginForm";
    }

    @GetMapping("/kakao/login")
    public String kakaoLogin(@RequestParam(value = "code", required = false) String code, Model m, HttpSession session, RedirectAttributes redirect) throws Exception {

        String access_Token = ks.getAccessToken(code);

        HashMap<String, Object> userInfo = ks.getUserInfo(access_Token);


        String id = (String) userInfo.get("id");
        String email = (String) userInfo.get("email");

        if (ks.findByid(id) == null) {
            redirect.addFlashAttribute("id",id);
            redirect.addFlashAttribute("email",email);
            redirect.addFlashAttribute("nickname",(String) userInfo.get("nickname"));

            return "redirect:/kakao/SignPage";
        }
        Member user = ks.findByid(id);
        session.setAttribute("memberId", id);
        session.setAttribute("email", email);
        session.setAttribute("nickname", (String) userInfo.get("nickname"));					//세션저장

        session.setAttribute("userKakaoId", "Kakao"+id);


        return "redirect:/main";		//메인페이지로


    }

    @PostMapping("/kakao/new")
    public String kakaoNew(Member m){
        ks.kakaoNew(m);
        return "redirect:/login";
    }

}


