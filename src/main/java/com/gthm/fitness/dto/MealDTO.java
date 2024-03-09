package com.gthm.fitness.dto;

import com.gthm.fitness.entity.FoodItem;
import com.gthm.fitness.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDTO {
    private Long mealId;
    private Long userId;
    private String mealName;
    private String mealType;
    private LocalDateTime mealTime;
    private Set<FoodItem> foodItems;
    private int calories;

    public MealDTO(Meal meal) {
        this.mealId = meal.getMealId();
        this.userId = meal.getUser().getUserId();
        this.mealName = meal.getMealName();
        this.mealType = meal.getMealType();
        this.mealTime = meal.getMealTime();
        this.foodItems = meal.getFoodItems();
        this.calories = meal.getCalories();
    }
}
