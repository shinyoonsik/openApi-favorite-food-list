package com.example.restaurent.wishlist.h2;

import com.example.restaurent.wishlist.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListH2Repository extends JpaRepository<WishListEntity, Long> {

}
