package com.gthm.fitness.service;

import com.gthm.fitness.dto.FoodItemDTO;

import java.util.List;

public interface FoodItemService {

    List<FoodItemDTO> getAllFoodItems();

    FoodItemDTO getFoodItemById(Long foodItemId);

    FoodItemDTO createFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO updateFoodItem(Long foodItemId, FoodItemDTO foodItemDTO);

    void deleteFoodItem(Long foodItemId);
}
