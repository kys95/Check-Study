package com.kys95.checkstudy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Feedback extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="taskId")
    private Task task;
}
