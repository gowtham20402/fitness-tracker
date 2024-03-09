package com.gthm.fitness.dto;

import com.gthm.fitness.entity.Workout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDTO {
    private Long workoutId;
    private Long userId;
    private String workoutName;
    private String duration;
    private String intensityLevel;
    private Time startTime;
    private Time endTime;
    private List<String> exercises;
    private int caloriesBurned;

    public WorkoutDTO(Workout workout) {
        this.workoutId = workout.getWorkoutId();
        this.userId = workout.getUser().getUserId();
        this.workoutName = workout.getWorkoutName();
        this.duration = workout.getDuration();
        this.intensityLevel = workout.getIntensityLevel();
        this.startTime = workout.getStartTime();
        this.endTime = workout.getEndTime();
        this.exercises = workout.getExercises();
        this.caloriesBurned = workout.getCaloriesBurned();
    }
}
