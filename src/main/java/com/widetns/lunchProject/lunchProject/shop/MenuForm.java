package com.widetns.lunchProject.lunchProject.shop;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class MenuForm {

    @Column(name = "shop_name" , length = 200)
    private String shopName;

    @Column(name = "shop_intro", length = 200)
    private String shopIntro;

    @Column(name = "shop_content", length = 2000)
    private String shopContent;


}
