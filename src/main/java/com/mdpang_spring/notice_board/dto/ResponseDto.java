package com.mdpang_spring.notice_board.dto;


import com.mdpang_spring.notice_board.entity.NoticeBoard;
import lombok.Getter;

@Getter
public class ResponseDto {
    private long id;
    private String title;
    private String username;
    private String contents;

    public ResponseDto(NoticeBoard noticeBoard) {
        this.id= noticeBoard.getId();
        this.username = noticeBoard.getUsername();
        this.title=noticeBoard.getTitle();
        this.contents=noticeBoard.getContents();
    }
}
