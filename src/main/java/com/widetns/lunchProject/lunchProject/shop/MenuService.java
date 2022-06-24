package com.widetns.lunchProject.lunchProject.shop;

import java.util.List;

public interface MenuService {

    // 목록 출력
    public List<MenuVO> getBoardList();

    // 글 작성
    public void insertShop(MenuVO vo);
    // 글 상세보기
    //public MenuVO detailShop(MenuVO vo);
    // 글 수정

    // 글 삭제

}
