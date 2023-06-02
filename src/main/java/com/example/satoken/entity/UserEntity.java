package com.example.satoken.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xsq
 * @version 1.0
 * @description: TODO
 * @date 2023/5/27 14:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("user_test")
public class UserEntity {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String username;

    private String password;
}
