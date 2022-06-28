package com.widetns.lunchProject.lunchProject.shop;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MenuService {

    // 목록 출력
    public List<MenuVO> getBoardList();

    // 글 작성
    public String insertShop(MenuVO vo);
    // 글 상세보기
    public MenuVO detailShop( Integer shopNum);
    // 글 수정
    public void modifyShop(MenuVO newVo);

    // 글 삭제
    public void deleteShop(String name);

    public MenuVO findByshopName(String name);

}
