package com.kentchiu.tree.visitor;


import com.kentchiu.tree.domain.Node;
import com.kentchiu.tree.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

public class LeafVisitor<T extends Node> implements Visitor<T> {


    private List<T> leaves = new ArrayList<>();

    public List<T> getLeaves() {
        return leaves;
    }

    @Override
    public boolean visitEnter(T node) {
        if (node.getChildren().isEmpty()) {
            leaves.add(node);
        }
        return true;
    }

    @Override
    public boolean visitLeave(T node) {
        return true;
    }

    @Override
    public boolean visit(T node) {
        return true;
    }
}
