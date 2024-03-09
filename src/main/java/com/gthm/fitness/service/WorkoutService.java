package com.gthm.fitness.service;

import com.gthm.fitness.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {

    List<WorkoutDTO> getAllWorkouts();

    WorkoutDTO getWorkoutById(long workoutId);

    WorkoutDTO createWorkout(WorkoutDTO workoutDTO);

    WorkoutDTO updateWorkout(long workoutId, WorkoutDTO workoutDTO);

    void deleteWorkout(long workoutId);
}
