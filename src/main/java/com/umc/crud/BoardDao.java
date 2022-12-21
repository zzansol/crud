package com.umc.crud;

import com.umc.crud.model.GetBoardRes;
import com.umc.crud.model.PatchBoardReq;
import com.umc.crud.model.PostBoardReq;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class BoardDao {

    private final  JdbcTemplate jdbcTemplate;

    //모든 게시판 불러오기
    public List<GetBoardRes> getBoard(){
        String sql = "SELECT * FROM board";
            return this.jdbcTemplate.query(sql,
                    (rs, count) -> new GetBoardRes(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getString("writer"))
            );
    }

    //게시판 추가
    public int addBoard(PostBoardReq postBoardReq){

        String sql = "insert into board (title,content,writer) values (?,?,?)";
        Object[] addUserParams = new Object[]{
                postBoardReq.getTitle(),postBoardReq.getContent(),postBoardReq.getWriter()
        };
        this.jdbcTemplate.update(sql,addUserParams);

        return this.jdbcTemplate.queryForObject("select id from user where id = 1",int.class);
    }

    //게시판 수정
    public int editBoard(int editUserId, PatchBoardReq patchBoardReq){
        String sql = "update board set title=?,content=?,writer=? where id ="+editUserId;
        Object[] editUserParams = new Object[]{patchBoardReq.getTitle(),patchBoardReq.getContent(),patchBoardReq.getWriter()};
        this.jdbcTemplate.update(sql,editUserParams);

        return editUserId;
    }

    public int deleteBoard(int deleteUserId){
        String sql = "delete from board where id = ?";
        this.jdbcTemplate.update(sql,deleteUserId);
        return this.jdbcTemplate.update(sql,deleteUserId);
    }
}
