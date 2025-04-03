package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.entity.Icon;
import com.example.demo.entity.Statistics;
import com.example.demo.entity.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.IconRepository;
import com.example.demo.repository.StatisticsRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatisticsRepository statisticsRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private IconRepository iconRepository;

    @GetMapping("/data")
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();

        User user = userRepository.findAll().stream().findFirst().orElse(null);
        if (user != null) {
            data.put("avatarUrl", user.getAvatarUrl());
            data.put("userInfo", user);
        }

        Statistics statistics = statisticsRepository.findAll().stream().findFirst().orElse(null);
        if (statistics != null) {
            data.put("statistics", statistics);
        }

        List<Article> articles = articleRepository.findAll();
        data.put("articles", articles);

        List<Icon> icons = iconRepository.findAll();
        data.put("icons", icons);

        // 这里简单模拟图片地址，实际中可以从数据库或其他存储中获取
        String[] imageUrls = {
                "https://dummyimage.com/400x400/000/fff",
                "https://dummyimage.com/400x400/000/fff",
                "https://dummyimage.com/400x400/000/fff"
        };
        data.put("imageUrls", imageUrls);

        return data;
    }
}    