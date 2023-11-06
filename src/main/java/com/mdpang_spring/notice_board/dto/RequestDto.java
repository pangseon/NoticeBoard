package com.mdpang_spring.notice_board.dto;


import lombok.Getter;

@Getter
public class RequestDto {
    private long id;
    private String title;
    private String username;
    private String password;
    private String contents;


}
