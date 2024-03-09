package com.gthm.fitness.service;

import com.gthm.fitness.dto.MealDTO;
import com.gthm.fitness.entity.Meal;
import com.gthm.fitness.entity.User;
import com.gthm.fitness.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public List<MealDTO> getAllMeals() {
        List<Meal> meals = mealRepository.findAll();
        return meals.stream().map(MealDTO::new).collect(Collectors.toList());
    }

    @Override
    public MealDTO getMealById(Long mealId) {
        Meal meal = mealRepository.findById(mealId)
                .orElseThrow(() -> new RuntimeException("Meal not found with id: " + mealId));
        return new MealDTO(meal);
    }

    @Override
    public MealDTO createMeal(MealDTO mealDTO) {
        Meal meal = new Meal();
        mapMealDTOToMeal(mealDTO, meal);
        Meal savedMeal = mealRepository.save(meal);
        return new MealDTO(savedMeal);
    }

    @Override
    public MealDTO updateMeal(Long mealId, MealDTO mealDTO) {
        Meal meal = mealRepository.findById(mealId)
                .orElseThrow(() -> new RuntimeException("Meal not found with id: " + mealId));
        mapMealDTOToMeal(mealDTO, meal);
        Meal updatedMeal = mealRepository.save(meal);
        return new MealDTO(updatedMeal);
    }

    @Override
    public void deleteMeal(Long mealId) {
        mealRepository.deleteById(mealId);
    }

    private void mapMealDTOToMeal(MealDTO mealDTO, Meal meal) {
        meal.setMealName(mealDTO.getMealName());
        meal.setMealType(mealDTO.getMealType());
        meal.setMealTime(mealDTO.getMealTime());
        meal.setFoodItems(mealDTO.getFoodItems());
        meal.setCalories(mealDTO.getCalories());
        // You may also map other fields as needed
        User user = new User();
        user.setUserId(mealDTO.getUserId());
        meal.setUser(user);
    }
}
