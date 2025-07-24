package com.example.controller;

import com.example.model.Post;
import com.example.service.PostService;
import com.example.service.impl.PostServiceImpl;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService = new PostServiceImpl();

    // 公告列表
    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "list";
    }

    // 顯示新增公告頁
    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("post", new Post());
        return "new";
    }

    // 處理新增公告表單送出
    @PostMapping("/add")
    public String addPost(@ModelAttribute("post") @Valid Post post,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "new";  // 有錯誤回到表單頁面
        }
        post.setPublishDate(new Date()); // 預設發佈日為今天
        postService.save(post);
        return "redirect:/posts";
    }

    // 顯示編輯公告頁
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "edit";
    }

    // 處理修改公告
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") @Valid Post post,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "edit"; // 有錯誤回到編輯頁面
        }
        postService.update(post);
        return "redirect:/posts";
    }

    // 刪除公告
    @GetMapping("/delete")
    public String deletePost(@RequestParam("id") int id) {
        postService.delete(id);
        return "redirect:/posts";
    }

    // 將文字轉換成 Date
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
