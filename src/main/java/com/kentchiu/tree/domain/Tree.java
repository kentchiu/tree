package com.kentchiu.tree.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Tree {

    private Tree() {

    }

    public static <T extends Node> List<T> buildFromList(List<T> nodes) {
        Tree tree = new Tree();
        return tree.toTrees(nodes);
    }

    <T extends Node> List<T> toTrees(List<T> cs) {
        List<T> results = cs.stream().filter(c -> c.getParent() == null).collect(Collectors.toList());
        for (Node parent : results) {
            addChild(cs, parent);
        }
        return results;
    }

    private void addChild(List<? extends Node> nodes, Node parent) {
        nodes.stream().filter(c -> Objects.equals(parent, c.getParent())).forEach(c -> {
            parent.addChild(c);
            c.setParent(parent);
            addChild(nodes, c);
        });
    }


}
