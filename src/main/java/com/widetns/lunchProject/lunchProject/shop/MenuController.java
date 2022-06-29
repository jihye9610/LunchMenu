package com.widetns.lunchProject.lunchProject.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController // @ResponseBody 자동으로 붙은 컨트롤러 어노테이션
public class MenuController {

    @Autowired
    private MenuService menuservice;

    // 목록 보기
    @GetMapping("main")
    public ModelAndView menuBoard(Model m) {
//        List<MenuVO> check = menuservice.getBoardList();
//        System.out.println(check);
//        m.addAttribute("shoplist", menuservice.getBoardList());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        mv.addObject("shoplist", menuservice.getBoardList());
        return mv;
    }

    // 글 작성 페이지 이동
    @GetMapping("/insertShop")
    public String insertShop() {
        return "shopBoard/insertShop";
    }

    // 글 작성
    @GetMapping ("/saveShop")  //  파라미터에 json으로 데이터 집어넣기 위해서 @RequestBody 어노테이션 넣겠음.
    public String saveShop(MenuForm form) {
        MenuVO vo = new MenuVO();
        vo.setShopName(form.getShopName());
        vo.setShopIntro(form.getShopIntro());
        vo.setShopContent(form.getShopContent());
        menuservice.insertShop(vo);
        return "redirect:main";
    }

    // 글 상세보기
    @GetMapping("/detailShop/{shopNum}")
    @ResponseBody
    public MenuVO detailShop(@PathVariable Integer shopNum) {
        MenuVO result = menuservice.detailShop(shopNum);
        return result;
    }

    @PutMapping("/detailShop/{id}")
    @ResponseBody
    public String updateShop(MenuVO menu ,@PathVariable Integer id){
        System.out.println(menu.getShopIntro()+"zzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println(menu.getShopName()+"/"+menu.getShopContent());
        System.out.println(id);

        MenuVO find = detailShop(id);

        find.setShopName(menu.getShopName());
        find.setShopIntro(menu.getShopIntro());
        find.setShopContent(menu.getShopContent());

        System.out.println(find);
        menuservice.updateShop(find);

        return "수정이 되었습니다.";
//        this.menuservice.updateShop(vo);

    }

    @DeleteMapping("/detailShop/{shopNum}")
    public void deleteShop(@PathVariable Integer shopNum){
        menuservice.deleteShop(shopNum);
    }

}






























