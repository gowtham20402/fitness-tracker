package com.gthm.fitness.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workout")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "workout_id")
    private long workoutId;

    @Column(name = "workout_name")
    private String workoutName;

    @Column(name = "time")
    private String duration;

    @Column(name = "difficulty")
    private String intensityLevel;

    @Column(name = "st")
    private Time startTime;

    @Column(name = "et")
    private Time endTime;

    @ElementCollection
    @CollectionTable(name = "exercise", joinColumns = @JoinColumn(name = "workout_id"))
    @Column(name = "exercise_name")
    private List<String> exercises;

    @Column(name = "burned")
    private int caloriesBurned;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
