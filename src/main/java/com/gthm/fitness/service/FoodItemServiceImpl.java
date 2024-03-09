package com.gthm.fitness.service.impl;

import com.gthm.fitness.dto.FoodItemDTO;
import com.gthm.fitness.entity.FoodItem;
import com.gthm.fitness.repository.FoodItemRepository;
import com.gthm.fitness.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemServiceImpl(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @Override
    public List<FoodItemDTO> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemRepository.findAll();
        return foodItems.stream().map(FoodItemDTO::new).collect(Collectors.toList());
    }

    @Override
    public FoodItemDTO getFoodItemById(Long foodItemId) {
        FoodItem foodItem = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new RuntimeException("FoodItem not found with id: " + foodItemId));
        return new FoodItemDTO(foodItem);
    }

    @Override
    public FoodItemDTO createFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = new FoodItem();
        mapFoodItemDTOToFoodItem(foodItemDTO, foodItem);
        FoodItem savedFoodItem = foodItemRepository.save(foodItem);
        return new FoodItemDTO(savedFoodItem);
    }

    @Override
    public FoodItemDTO updateFoodItem(Long foodItemId, FoodItemDTO foodItemDTO) {
        FoodItem foodItem = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new RuntimeException("FoodItem not found with id: " + foodItemId));
        mapFoodItemDTOToFoodItem(foodItemDTO, foodItem);
        FoodItem updatedFoodItem = foodItemRepository.save(foodItem);
        return new FoodItemDTO(updatedFoodItem);
    }

    @Override
    public void deleteFoodItem(Long foodItemId) {
        foodItemRepository.deleteById(foodItemId);
    }

    private void mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO, FoodItem foodItem) {
        foodItem.setFoodName(foodItemDTO.getFoodName());
        foodItem.setCalories(foodItemDTO.getCalories());
        foodItem.setProtein(foodItemDTO.getProtein());
        foodItem.setCarbohydrates(foodItemDTO.getCarbohydrates());
        foodItem.setFat(foodItemDTO.getFat());
        // You may also map other fields as needed
    }
}
