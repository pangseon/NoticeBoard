package com.mdpang_spring.notice_board.entity;


import com.mdpang_spring.notice_board.dto.RequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 데이터 조회
@Getter
// 데이터 입력
@Setter
// entity는 무조건 NoArgsConstructor를 가져야 한다
//
@NoArgsConstructor
public class NoticeBoard {
    private long id;
    private String title;
    private String username;
    private String password;
    private String contents;
    public NoticeBoard(RequestDto requestDto){
        this.id = requestDto.getId();
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();

    }

    public void update(RequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents=requestDto.getContents();

    }
}

