package com.gthm.fitness.controller;

import com.gthm.fitness.dto.FoodItemDTO;
import com.gthm.fitness.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foodItems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public ResponseEntity<List<FoodItemDTO>> getAllFoodItems() {
        List<FoodItemDTO> foodItems = foodItemService.getAllFoodItems();
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    @GetMapping("/{foodItemId}")
    public ResponseEntity<FoodItemDTO> getFoodItemById(@PathVariable Long foodItemId) {
        FoodItemDTO foodItem = foodItemService.getFoodItemById(foodItemId);
        return new ResponseEntity<>(foodItem, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FoodItemDTO> createFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO createdFoodItem = foodItemService.createFoodItem(foodItemDTO);
        return new ResponseEntity<>(createdFoodItem, HttpStatus.CREATED);
    }

    @PutMapping("/{foodItemId}")
    public ResponseEntity<FoodItemDTO> updateFoodItem(@PathVariable Long foodItemId, @RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO updatedFoodItem = foodItemService.updateFoodItem(foodItemId, foodItemDTO);
        return new ResponseEntity<>(updatedFoodItem, HttpStatus.OK);
    }

    @DeleteMapping("/{foodItemId}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long foodItemId) {
        foodItemService.deleteFoodItem(foodItemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
