package com.plexpt.chatgpt.web.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AjaxResult<T> {

    private String msg;   // 返回消息
    private int code;     // 返回码
    private T data;       // 返回数据

    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult<>("请求成功", 200, data);
    }

    public static <T> AjaxResult<T> success() {
        return success(null);
    }

    public static <T> AjaxResult<T> fail(String msg, int code) {
        return new AjaxResult<>(msg, code, null);
    }

}
