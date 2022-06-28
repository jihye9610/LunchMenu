package com.widetns.lunchProject.lunchProject.shop;

import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<MenuVO, Integer> {

    public void deleteByshopName(String name);

    public MenuVO findByshopName(String name);

}
