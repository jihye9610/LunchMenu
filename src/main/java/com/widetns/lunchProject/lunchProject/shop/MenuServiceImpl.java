package com.widetns.lunchProject.lunchProject.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
    public MenuVO detailShop(Integer shopNum) {

        return menurepo.findById(shopNum).get(); // Integer shopNum  .get();
    }


    @Override
    public void updateShop(MenuVO find) {
        menurepo.save(find);
    }

    @Override
    public void deleteShop(Integer id) {
           menurepo.deleteById(id);

    }


}

