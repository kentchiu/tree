package com.kentchiu.tree.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public interface Node<T> {

    @JsonIgnore
    T getParent();

    void setParent(T parent);

    boolean accept(Visitor visitor);

    @JsonIgnore
    List<T> getChildren();

    void addChild(T node);

}
