package com.kor45cw.retrofitexample.Retrofit.RequestBody;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by sonchangwoo on 2017. 1. 6..
 */

public class RequestPut {

    private final int userId;
    private final int id;
    private final String title;
    private final String body;

    public RequestPut(HashMap<String, Object> parameters) {
        this.userId = (int) parameters.get("userId");
        this.id = (int) parameters.get("id");
        this.title = (String) parameters.get("title");
        this.body = (String) parameters.get("body");
    }
}
