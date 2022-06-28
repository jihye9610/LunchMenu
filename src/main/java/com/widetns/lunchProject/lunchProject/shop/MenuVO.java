package com.widetns.lunchProject.lunchProject.shop;

import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="shop")
@NoArgsConstructor
public class MenuVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_num")
    private Integer shopNum;

    @Column(name = "shop_name" , length = 200)
    private String shopName;

    @Column(name = "shop_intro", length = 200)
    private String shopIntro;

    @Column(name = "shop_content", length = 2000)
    private String shopContent;

    @Column(name = "shop_like")
    private int shopLike;


    public MenuVO(Integer shopNum, String shopName, String shopIntro, String shopContent, int shopLike){
        this.shopNum = shopNum;
        this.shopName = shopName;
        this.shopIntro = shopIntro;
        this.shopContent = shopContent;
        this.shopLike = shopLike;
    }

    public static MenuVO sample(){
        return new MenuVO(1,"rest", "thisIsGood", "VeryGood", 1);
    }

    public static void main(String[] args) {
        MenuVO menu = new MenuVO(1,"rest1","thisIsGood!","VeryGood!",2);
        System.out.println(new Gson().toJson(menu));
    }

}
