package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.CommentDTO;
import com.codingrecipe.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/save")
    public ResponseEntity save(@ModelAttribute CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);
        Long saveResult = commentService.save(commentDTO);
        if (saveResult != null) {
            // 작성 성공하면 댓글목록을 가져와서 리턴
            // 댓글목록: 해당 게시글의 댓글 전체 -> 즉, 해당 게시글 ID를 기준으로 해당되는 댓글을 다 가져오기.
            List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK); // Entity는 Body와 Header를 다룰 수 있는 객체이다. 그래서 데이터 바디 값인
            // commentDTOList와 상태값인 HttpStatus.OK를 보낸다.
        } else {
            return new ResponseEntity<>("해당 게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }
    }

}
