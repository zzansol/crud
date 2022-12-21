package com.umc.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatchBoardReq {
    private String title;
    private String content;
    private String writer;
}
