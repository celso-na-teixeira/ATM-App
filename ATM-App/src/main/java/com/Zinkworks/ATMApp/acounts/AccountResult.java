package com.Zinkworks.ATMApp.acounts;

import java.io.Serializable;
import java.util.List;

public class AccountResult<T>  {
    private T obj;
    private List<String> errList;

    public AccountResult() {
    }

    public AccountResult(T obj, List<String> errList) {
        this.obj = obj;
        this.errList = errList;
    }

    public T getObj() {
        return obj;
    }

    public List<String> getErrList() {
        return errList;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setErrList(List<String> errList) {
        this.errList = errList;
    }


}
