package com.umc.crud;

import com.umc.crud.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardProvider {

    private BoardDao boardDao;

    @Autowired
    public BoardProvider(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    public List<GetBoardRes> getBoard(){
        List<GetBoardRes> getBoardRes = boardDao.getBoard();
        return getBoardRes;
    }

    public PostBoardRes addBoard(PostBoardReq postBoardReq){
        int addBoardId = boardDao.addBoard(postBoardReq);
        PostBoardRes postBoardRes = new PostBoardRes(addBoardId);
        return postBoardRes;
    }

    public PatchBoardRes editBoard(int editUserId, PatchBoardReq patchBoardReq){
        int changeUserId = boardDao.editBoard(editUserId, patchBoardReq);
        PatchBoardRes patchBoardRes = new PatchBoardRes(changeUserId);
        return patchBoardRes;
    }

    public DeleteBoardRes deleteBoard(int deleteUserId){
        int dUserId = boardDao.deleteBoard(deleteUserId);
        DeleteBoardRes deleteBoardRes = new DeleteBoardRes(dUserId);
        return deleteBoardRes;
    }



}
