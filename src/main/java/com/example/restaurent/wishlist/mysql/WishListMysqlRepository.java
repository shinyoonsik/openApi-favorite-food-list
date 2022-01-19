package com.example.restaurent.wishlist.mysql;

import com.example.restaurent.wishlist.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListMysqlRepository extends JpaRepository<WishListEntity, Long> {
}
