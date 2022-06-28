package com.widetns.lunchProject.lunchProject.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private final MenuRepository menurepo;

    // 게시글 목록 출력
    @Override
    public List<MenuVO> getBoardList() {
        return (List<MenuVO>) menurepo.findAll();
    }
    // 글 작성
    @Override
    public String insertShop(MenuVO vo) {
         this.menurepo.save(vo);
         return vo.getShopName();
    }


   //글찾기



    // 글 상세보기
    public MenuVO detailShop( Integer shopNum) {
        return menurepo.findById(shopNum).get();
    }

    @Override
    public void modifyShop(MenuVO newVo) {
        //save 메소드는 기존에 있을시수정을 해줌
        menurepo.save(newVo);

    }
    @Override
    public void deleteShop(String name) {
        menurepo.deleteByshopName(name);
    }

    @Override
    public MenuVO findByshopName(String name) {
        return this.menurepo.findByshopName(name);
    }


}

