package com.umc.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetBoardRes {
    private int id;
    private String title;
    private String content;
    private String writer;
}
