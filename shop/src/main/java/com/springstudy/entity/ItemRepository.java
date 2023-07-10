package com.springstudy.entity;

import com.springstudy.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findByItemNm(String itemNm);
    List<Item> findByItemNmOrItemDeatail(String itemNm,String itemDatail);
    List<Item> findByPriceLessThanOrderByItemNmDesc(Integer price);



}
// 쿼리메서드
//  find + (엔티티이름) + By + 변수이름(엔티티속성(필드)명)