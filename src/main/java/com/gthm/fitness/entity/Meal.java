package com.gthm.fitness.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meal")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long mealId;

    @Column(name = "meal_name")
    private String mealName;

    @Column(name = "meal_type")
    private String mealType;

    @Column(name = "meal_time")
    private LocalDateTime mealTime;

    @ManyToMany
    @JoinTable(
            name = "meal_item",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "food_item_id")
    )
    private Set<FoodItem> foodItems;

    @Column(name = "calories")
    private int calories;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
