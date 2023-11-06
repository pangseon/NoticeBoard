package com.mdpang_spring.notice_board.controller;


import com.mdpang_spring.notice_board.dto.RequestDto;
import com.mdpang_spring.notice_board.dto.ResponseDto;
import com.mdpang_spring.notice_board.entity.NoticeBoard;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class NoticeBoardController {

    private final Map<Long, NoticeBoard>  noticelist= new HashMap<>();


    @PostMapping("/notice")
    public RequestDto createNotices(@RequestBody RequestDto requestDto){
        NoticeBoard noticeBoard = new NoticeBoard(requestDto);

        Long maxId = noticelist.size() >0? Collections.max(noticelist.keySet())+1 :1;

        noticeBoard.setId(maxId);

        noticelist.put(noticeBoard.getId(),noticeBoard);

        ResponseDto responseDto = new ResponseDto(noticeBoard);

        return requestDto;

    }
    @GetMapping("/notice")
    public List<ResponseDto> getNotice(){
        List<ResponseDto> responseDtos = noticelist.values().stream().map(ResponseDto::new).toList();
        return responseDtos;

    }

    @PutMapping("/notice")
    public Long updateNotice(@PathVariable Long id,@PathVariable String password,@RequestBody RequestDto requestDto)
            throws IllegalAccessException {
        if (noticelist.containsKey(id)&&noticelist.get(id).getPassword().equals(password)){
                NoticeBoard noticeBoard = noticelist.get(id);
                noticeBoard.update(requestDto);
                return noticeBoard.getId();
            }
        else {
            throw new IllegalAccessException("선택한 메뉴는 존재하지않습니다");
        }
    }
    @DeleteMapping("/notice")
    public Long deletenotice(@PathVariable Long id,@PathVariable String password) throws IllegalAccessException {
        if (noticelist.containsKey(id)&&noticelist.get(id).getPassword().equals(password)){
            noticelist.remove(id);
            return id;
        }
        else {
            throw new IllegalAccessException("선택한 메뉴는 존재하지않습니다.");
        }
    }



}
