package com.umc.crud;

import com.umc.crud.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private BoardProvider boardProvider;

    @Autowired
    public BoardController(BoardProvider boardProvider){
        this.boardProvider = boardProvider;
    }

    @GetMapping("/boardList")
    public List<GetBoardRes> getBoard(){
        List<GetBoardRes> getBoardRes = boardProvider.getBoard();
        return getBoardRes;
    }

    @PostMapping("/addBoard")
    @ResponseBody
    public PostBoardRes addBoard(@RequestBody PostBoardReq postBoardReq){
        PostBoardRes postBoardRes = boardProvider.addBoard(postBoardReq);
        return postBoardRes;
    }

    @PatchMapping("/{id}")
    public PatchBoardRes editBoard(@PathVariable("id") int editUserId, @RequestBody PatchBoardReq patchBoardReq){
        PatchBoardRes patchBoardRes = boardProvider.editBoard(editUserId, patchBoardReq);
        return patchBoardRes;
    }

    @DeleteMapping("/{id}")
    public DeleteBoardRes deleteBoard(@PathVariable("id") int deleteUserId){
        DeleteBoardRes deleteBoardRes = boardProvider.deleteBoard(deleteUserId);
        return deleteBoardRes;
    }



}
