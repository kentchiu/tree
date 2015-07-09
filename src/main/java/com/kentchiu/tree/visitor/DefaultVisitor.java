package com.kentchiu.tree.visitor;


import com.kentchiu.tree.domain.Node;
import com.kentchiu.tree.domain.Visitor;

import java.util.function.Function;

public class DefaultVisitor<T extends Node> implements Visitor<T> {

    private Function<T, String> function;

    public DefaultVisitor(Function<T, String> function) {
        this.function = function;
    }


    @Override
    public boolean visitEnter(T node) {
        System.out.println("--->  " + function.apply(node));
        return true;
    }

    @Override
    public boolean visitLeave(T node) {
        System.out.println("<---  " + function.apply(node));
        return true;
    }

    @Override
    public boolean visit(T node) {
        System.out.println("----  " + function.apply(node));
        return true;
    }
}
