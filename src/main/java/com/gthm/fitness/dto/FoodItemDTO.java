package com.gthm.fitness.dto;
import com.gthm.fitness.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
    private Long foodItemId;
    private String foodName;
    private int calories;
    private double protein;
    private double carbohydrates;
    private double fat;

    public FoodItemDTO(FoodItem foodItem) {
        this.foodItemId = foodItem.getFoodItemId();
        this.foodName = foodItem.getFoodName();
        this.calories = foodItem.getCalories();
        this.protein = foodItem.getProtein();
        this.carbohydrates = foodItem.getCarbohydrates();
        this.fat = foodItem.getFat();
    }
}
