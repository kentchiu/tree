package com.kentchiu.tree.visitor;


import com.kentchiu.tree.domain.Node;
import com.kentchiu.tree.domain.Visitor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TreePrintVisitor<T extends Node> implements Visitor<T> {

    int i = 0;
    private Function<T, String> function;
    private List<String> lines = new ArrayList<>();

    public TreePrintVisitor(Function<T, String> function) {
        this.function = function;
    }

    public List<String> getLines() {
        return lines;
    }

    protected void dump(T node) {
        String repeat = StringUtils.repeat(" │ ", i - 1);
        String line = repeat + " ├─ " + function.apply(node);
        lines.add(line);
    }

    @Override
    public boolean visitEnter(T node) {
        i++;
        return true;
    }

    @Override
    public boolean visitLeave(T node) {
        i--;
        return true;
    }

    @Override
    public boolean visit(T node) {
        dump(node);
        return true;
    }
}
