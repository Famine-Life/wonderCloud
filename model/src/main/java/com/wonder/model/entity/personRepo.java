package com.wonder.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wonder.model.base.BaseEntity;
import lombok.Data;

@Data
public class personRepo extends BaseEntity {
    private Long userId;
    private String introdution;
    private String githubRepoUrl;
    private Integer repoStatus;
}
