package com.tibby.notepad.app.domain;

import java.io.Serializable;

/**
 * Author:tibby tang
 * Created on 4/12/14.
 * Email:tangjian19900607@gmail.com
 * QQ:562980080
 */
public class Notepad implements Serializable {

    private String title;
    private String content;

    public Notepad() {
    }

    public Notepad(String title, String content) {

        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
