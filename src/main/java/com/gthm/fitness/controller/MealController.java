package com.gthm.fitness.controller;

import com.gthm.fitness.dto.MealDTO;
import com.gthm.fitness.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public ResponseEntity<List<MealDTO>> getAllMeals() {
        List<MealDTO> meals = mealService.getAllMeals();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @GetMapping("/{mealId}")
    public ResponseEntity<MealDTO> getMealById(@PathVariable Long mealId) {
        MealDTO meal = mealService.getMealById(mealId);
        return new ResponseEntity<>(meal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MealDTO> createMeal(@RequestBody MealDTO mealDTO) {
        MealDTO createdMeal = mealService.createMeal(mealDTO);
        return new ResponseEntity<>(createdMeal, HttpStatus.CREATED);
    }

    @PutMapping("/{mealId}")
    public ResponseEntity<MealDTO> updateMeal(@PathVariable Long mealId, @RequestBody MealDTO mealDTO) {
        MealDTO updatedMeal = mealService.updateMeal(mealId, mealDTO);
        return new ResponseEntity<>(updatedMeal, HttpStatus.OK);
    }

    @DeleteMapping("/{mealId}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long mealId) {
        mealService.deleteMeal(mealId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
