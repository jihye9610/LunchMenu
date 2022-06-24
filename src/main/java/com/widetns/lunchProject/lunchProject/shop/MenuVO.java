package com.widetns.lunchProject.lunchProject.shop;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="shop")
public class MenuVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_num")
    private int shopNum;

    @Column(name = "shop_name" , length = 200)
    private String shopName;

    @Column(name = "shop_intro", length = 200)
    private String shopIntro;

    @Column(name = "shop_content", length = 2000)
    private String shopContent;

    @Column(name = "shop_like")
    private int shopLike;

}
