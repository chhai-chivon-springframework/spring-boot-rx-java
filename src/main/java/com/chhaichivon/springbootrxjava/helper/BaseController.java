package com.chhaichivon.springbootrxjava.helper;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by chhai.chivon  on 10/4/2017.
 */
public abstract class BaseController<T> {

    public static final String MESSAGE_SUCCESS = "SUCCESS";
    public static final String MESSAGE_FAILURE = "FAIL";
    private Map<String, Object> map = new HashMap<>();

    private Map<String, Object> mapJson(T object, HttpStatus status, String message) {
        if(object != null){
            map.put("DATA", object);
        }
        map.put("STATUS", status);
        map.put("MESSAGE", message);
        return map;
    }

    public ResponseEntity<Map<String, Object>> responseJson(T object) {
        if (object != null) {
            map = mapJson(object, HttpStatus.OK, MESSAGE_SUCCESS);
        } else {
            map = mapJson(null, HttpStatus.NOT_FOUND, MESSAGE_FAILURE);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> responseJson(List<T> objects) {
        if (!objects.isEmpty()) {
            map = mapJson((T) objects, HttpStatus.OK, MESSAGE_SUCCESS);
        } else {
            map = mapJson(null, HttpStatus.NOT_FOUND, MESSAGE_FAILURE);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<Page<T>> responseJson(Page<T> objects) {
        /*if (objects.hasContent()) {
            map = mapJson(T, HttpStatus.OK, MESSAGE_SUCCESS);
        } else {
            map = mapJson(null, HttpStatus.NOT_FOUND, MESSAGE_FAILURE);
        }*/
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }
}
