package com.example.common;

import java.util.List;

/**
 * @Author: suragi
 * @Date: 2024/12/26 22:51
 * @Description:
 */
public class SysUserRequest {
    private List<Long> userIds;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}

