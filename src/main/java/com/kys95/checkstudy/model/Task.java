package com.kys95.checkstudy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
}}
