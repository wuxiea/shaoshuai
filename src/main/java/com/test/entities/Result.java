package com.test.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
* 统一前端返回类型
* */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result  implements Serializable {

    private boolean success;
    private String message;
    private Object data;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}