package com.jtzh.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultResponse {
    private String message;
    private boolean success;
    private Collection rows;
    private int total;

    public Collection getRows() {
        return rows;
    }

    public void setRows(Collection rows) {
        this.rows = rows;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}