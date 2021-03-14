package edu.dhu.mooc.service;

import edu.dhu.mooc.entity.User;

import java.util.Map;

/**
 * @Author: xieyiming
 * @Describe: 负责登录的业务逻辑
 */
public interface LoginService {
    boolean hasAccount(User user);
}
