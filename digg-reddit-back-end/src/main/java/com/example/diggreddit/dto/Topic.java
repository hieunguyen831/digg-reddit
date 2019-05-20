package com.example.diggreddit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic {

    private String id;
    private String title;
    private String content;
    private int numOfUpVoting;
    private int numOfDownVoting;

}
