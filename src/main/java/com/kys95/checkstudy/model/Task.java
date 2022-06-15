package com.kys95.checkstudy.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
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

    private int isSuccess;
}
