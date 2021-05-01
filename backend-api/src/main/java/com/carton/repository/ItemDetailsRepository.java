package com.carton.repository;

import com.carton.model.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer> {
}
