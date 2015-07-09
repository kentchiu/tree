package com.kentchiu.tree.domain;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Node<Composite> {

    private String id;
    private Composite parent;
    private List<Composite> children;

    public Composite(String id) {
        this.id = id;
        parent = null;
        children = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composite composite = (Composite) o;

        return id.equals(composite.id);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public Composite getParent() {
        return parent;
    }

    public void setParent(Composite parent) {
        this.parent = parent;
    }

    @Override
    public boolean accept(Visitor visitor) {
        if (visitor.visitEnter(this)) {
            visitor.visit(this);
            for (Composite child : getChildren()) {
                child.accept(visitor);
            }
        }
        return visitor.visitLeave(this);
    }


    @Override
    public List<Composite> getChildren() {
        return children;
    }

    public void setChildren(List<Composite> children) {
        this.children = children;
    }


    public void addChild(Composite composite) {
        composite.setParent(this);
        children.add(composite);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Composite{");
        sb.append("id='").append(id).append('\'');
        if (parent != null) {
            sb.append("parent id='").append(parent.getId()).append('\'');
        }
        sb.append("child count='").append(children.size()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
