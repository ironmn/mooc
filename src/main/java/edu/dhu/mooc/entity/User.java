package edu.dhu.mooc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User{
    private String phone;
    private String password;
    private String role;
}
