package com.widetns.lunchProject.lunchProject.kakao;

import com.widetns.lunchProject.lunchProject.entity.Member;

import java.util.HashMap;

public interface KakaoService {

    public String getAccessToken (String authorize_code);


    public HashMap<String, Object> getUserInfo(String access_Token);

    public Member findByid(String id);

    public void kakaoNew(Member m);

}
