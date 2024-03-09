package com.gthm.fitness.service;

import com.gthm.fitness.dto.WorkoutDTO;
import com.gthm.fitness.entity.User;
import com.gthm.fitness.entity.Workout;
import com.gthm.fitness.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public List<WorkoutDTO> getAllWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();
        return workouts.stream().map(WorkoutDTO::new).collect(Collectors.toList());
    }

    @Override
    public WorkoutDTO getWorkoutById(long workoutId) {
        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found with id: " + workoutId));
        return new WorkoutDTO(workout);
    }

    @Override
    public WorkoutDTO createWorkout(WorkoutDTO workoutDTO) {
        Workout workout = new Workout();
        mapWorkoutDTOToWorkout(workoutDTO, workout);
        Workout savedWorkout = workoutRepository.save(workout);
        return new WorkoutDTO(savedWorkout);
    }

    @Override
    public WorkoutDTO updateWorkout(long workoutId, WorkoutDTO workoutDTO) {
        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found with id: " + workoutId));
        mapWorkoutDTOToWorkout(workoutDTO, workout);
        Workout updatedWorkout = workoutRepository.save(workout);
        return new WorkoutDTO(updatedWorkout);
    }

    @Override
    public void deleteWorkout(long workoutId) {
        workoutRepository.deleteById(workoutId);
    }

    private void mapWorkoutDTOToWorkout(WorkoutDTO workoutDTO, Workout workout) {
        workout.setWorkoutName(workoutDTO.getWorkoutName());
        workout.setDuration(workoutDTO.getDuration());
        workout.setIntensityLevel(workoutDTO.getIntensityLevel());
        workout.setStartTime(workoutDTO.getStartTime());
        workout.setEndTime(workoutDTO.getEndTime());
        workout.setExercises(workoutDTO.getExercises());
        workout.setCaloriesBurned(workoutDTO.getCaloriesBurned());

        // Set the User for the Workout entity
        User user = new User();
        user.setUserId(workoutDTO.getUserId());
        workout.setUser(user);

    }

}
