package com.widetns.lunchProject.lunchProject.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

