package com.widetns.lunchProject.lunchProject.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MenuController {

    @Autowired
    private MenuService menuservice;

    // 목록 보기
    @GetMapping("main")
    public String menuBoard(Model m) {
        m.addAttribute("shoplist", menuservice.getBoardList());
        return "main";
    }

    // 글 작성 페이지 이동
    @GetMapping("/insertShop")
    public String insertShop() {
        return "shopBoard/insertShop";
    }

    // 글 작성
    @GetMapping("saveShop")
    public String saveShop(MenuVO vo) {
        menuservice.insertShop(vo);
        return "redirect:main";
    }

    // 글 상세보기
    /*@PostMapping("/main")
    public void detailShop(MenuVO vo, Model m) {
        m.addAttribute("detail", menuservice.detailShop(vo));
    }*/
}
