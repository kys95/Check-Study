package com.kys95.checkstudy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "task" ,fetch = FetchType.EAGER, cascade =  CascadeType.REMOVE)
    @JsonIgnoreProperties({"task"})
    @OrderBy("id desc")
    private List<Feedback> feedbacks = new ArrayList<>();

    private int isSuccess;

    private String stringDeadline;

}
