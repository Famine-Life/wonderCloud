package com.wonder.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wonder.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PersonRepo extends BaseEntity {
    private Long userId;
    private String title;
    private String introdution;
    private String githubRepoUrl;
    private Integer repoStatus;
}
