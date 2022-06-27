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
        //	System.out.println("#########" + code); 		//확인할려고 출력
        String access_Token = ks.getAccessToken(code); // service의 토큰얻는 함수에 인자값으로 코드를 넣어 토근을 얻습니다.
        //	System.out.println("###access_Token#### : " + access_Token);	//확인 할려고 출력
        // 위에서 만든 코드 아래에 코드 추가
        HashMap<String, Object> userInfo = ks.getUserInfo(access_Token);	// 얻은 토큰을 통해 getUserInfo인자값으로 토큰을 넣고
        // 유저 정보를 가져옴


        String id = (String) userInfo.get("id");				// id 정보 String 타입으로 로 담기
        String email = (String) userInfo.get("email");

        if (ks.findByid(id) == null) {					// 카카오 컬럼에 카카오의id값이 없으면
            redirect.addFlashAttribute("id",id);
            redirect.addFlashAttribute("email",email);
            redirect.addFlashAttribute("nickname",(String) userInfo.get("nickname"));

            return "redirect:/kakao/SignPage";			// 카카오 회원가입페이지로
        }
        Member user = ks.findByid(id);
        session.setAttribute("memberId", id);							//세션저장
        session.setAttribute("email", email);					//세션저장
        session.setAttribute("nickname", (String) userInfo.get("nickname"));					//세션저장

        session.setAttribute("userKakaoId", "Kakao"+id);			//세션저장


        return "redirect:/main";		//메인페이지로


    }

    @PostMapping("/kakao/new")
    public String kakaoNew(Member m){
        ks.kakaoNew(m);
        return "redirect:/login";
    }

}


