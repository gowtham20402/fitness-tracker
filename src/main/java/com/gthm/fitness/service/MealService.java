package com.gthm.fitness.service;

import com.gthm.fitness.dto.MealDTO;

import java.util.List;

public interface MealService {

    List<MealDTO> getAllMeals();

    MealDTO getMealById(Long mealId);

    MealDTO createMeal(MealDTO mealDTO);

    MealDTO updateMeal(Long mealId, MealDTO mealDTO);

    void deleteMeal(Long mealId);
}
