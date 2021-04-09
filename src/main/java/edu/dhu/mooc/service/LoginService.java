package edu.dhu.mooc.service;

import edu.dhu.mooc.entity.LoginInfo;
import edu.dhu.mooc.entity.User;

import java.util.Map;

/**
 * @Author: xieyiming
 * @Describe: 负责登录的业务逻辑
 */
public interface LoginService {
    //用于返回是否有user信息。如果有User信息
    // 顺便返回User的角色数据（是属于Student还是Teacher）
    boolean hasAccount(User user);

    String findIdByUser(User user);

    boolean checkIfPhoneValid(String register_phone);

    void insertUser(User user);
}
