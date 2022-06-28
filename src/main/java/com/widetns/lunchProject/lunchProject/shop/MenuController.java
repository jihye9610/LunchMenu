package com.widetns.lunchProject.lunchProject.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;


@RestController
@RequiredArgsConstructor
public class MenuController {

    @Autowired
    private final MenuService menuservice;

    // 목록 보기
    @GetMapping("/main")
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
    @GetMapping("/detailShop/{shopNum}")
    @ResponseBody
    public MenuVO detailShop(@PathVariable Integer shopNum) {
        return menuservice.detailShop(shopNum);
    }


    //게시글 생성
    @PostMapping("/shops")
    public Integer register(@RequestBody MenuVO newVo){
        menuservice.insertShop(newVo);
        return newVo.getShopNum();
    }
    //게시글 삭제
    @DeleteMapping("/shops/{name}")
    public void delete(@PathVariable String name){
        menuservice.deleteShop(name);

    }
    //게시글 수정
    @PutMapping("/shops")
    public void updateShop(@RequestBody MenuVO vo){
        menuservice.insertShop(vo);

    }
    //게시글 찾기
    @GetMapping("/shops/{name}")
    public MenuVO findShop(@PathVariable String name, Model model) {
        MenuVO findShop = menuservice.findByshopName(name);
        return this.menuservice.findByshopName(name);
    }
}






























