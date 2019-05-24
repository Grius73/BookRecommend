package com.wudi.controller;

import com.github.pagehelper.PageInfo;
import com.wudi.mapper.CommentMapper;
import com.wudi.model.Comment;
import com.wudi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Controller
public class UserCommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    CommentMapper commentMapper;
    @GetMapping("/comments")
    public String toComment (@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                             HttpSession session, Model model){
        int userid= (Integer) session.getAttribute("loginUserid");
        PageInfo<Comment> comments=commentService.returnCommentByuserid(pageNum,pageSize,userid);
        model.addAttribute("usercomments",comments);
        return "comment/list";
    }
    /***删除用户的评论记录**/
//    @DeleteMapping("/comments")
//    public String deleteComment(Comment comment){
//        System.out.println(comment);
//        commentService.deleteComment(comment);
//        return "redirect:/comments";
//    }
      @DeleteMapping("/comment/{bookid}")
    public String deleteComment(@PathVariable("bookid") Integer bookid,
                                HttpSession session){
          int userid= (Integer) session.getAttribute("loginUserid");
          commentService.deleteCommentByTwi(bookid,userid);
          return "redirect:/comments";
      }
}
