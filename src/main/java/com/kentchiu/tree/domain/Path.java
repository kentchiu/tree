package com.kentchiu.tree.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.kentchiu.tree.visitor.LeafVisitor;

import java.util.ArrayList;
import java.util.List;

public class Path<T extends Node> {

    @JsonProperty
    private List<T> segments = new ArrayList<>();

    public static <T extends Node> List<Path<T>> buildFormTreeRoot(T root) {
        LeafVisitor<T> visitor = new LeafVisitor();
        root.accept(visitor);
        List<T> leaves = visitor.getLeaves();

        List<Path<T>> paths = new ArrayList<>();
        for (T leaf : leaves) {
            Path<T> path = new Path<>();
            path.segments.add(0, leaf);
            T node = (T) leaf.getParent();
            while (node != null) {
                path.segments.add(0, node);
                //segments.add(0, treeNode);
                node = (T) node.getParent();
                //System.out.println(node);
            }
            paths.add(path);
        }
        return paths;
    }


    public List<T> segments() {
        return segments;
    }

    public T head() {
        Preconditions.checkState(!segments.isEmpty(), "path is empty");
        return segments.get(0);
    }

    public T tail() {
        Preconditions.checkState(!segments.isEmpty(), "path is empty");
        return segments.get(segments.size() - 1);
    }

    /**
     * @param index zero-base index
     * @return
     */
    public T segment(int index) {
        Preconditions.checkPositionIndex(index, segments.size(), "index is out of segment count " + segments.size());
        return segments.get(index);
    }
}
