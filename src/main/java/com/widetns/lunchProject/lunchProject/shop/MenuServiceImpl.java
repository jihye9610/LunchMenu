package com.widetns.lunchProject.lunchProject.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menurepo;

    // 게시글 목록 출력
    @Override
    public List<MenuVO> getBoardList() {
        return (List<MenuVO>) menurepo.findAll();
    }


    // 글 작성
    public void insertShop(MenuVO vo) {
        menurepo.save(vo);
    }

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
    public void deleteShop(Integer id) {
        menurepo.deleteById(id);
    }


}

