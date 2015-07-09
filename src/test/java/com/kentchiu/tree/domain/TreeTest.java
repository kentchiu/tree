package com.kentchiu.tree.domain;


import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TreeTest {

    @Test
    public void testGetParent() throws Exception {
        Composite root = Composites.root();
        Optional<Composite> c_0_0_0_1 = Composites.findByPath(root, 0, 0, 0, 1);
        assertThat(c_0_0_0_1.get().getId(), is("0_0_0_1"));
        assertThat(c_0_0_0_1.get().getParent().getId(), is("0_0_0"));
        assertThat(c_0_0_0_1.get().getParent().getParent().getId(), is("0_0"));
        assertThat(c_0_0_0_1.get().getParent().getParent().getParent().getId(), is("0"));
        assertThat(c_0_0_0_1.get().getParent().getParent().getParent().getParent().getId(), is("root"));
        assertThat(c_0_0_0_1.get().getParent().getParent().getParent().getParent().getParent(), nullValue());
    }

    @Test
    public void testListToTree() throws Exception {
        List<Composite> all = Composites.all();
        List<Composite> trees = Tree.buildFromList(all);
        assertThat(trees.size(), is(3));

        assertNode(trees.get(0), "0", 3, "0_0", "0_1", "0_2");
        assertNode(trees.get(0).getChildren().get(0), "0_0", 3, "0_0_0", "0_0_1", "0_0_2");
        assertNode(trees.get(0).getChildren().get(1), "0_1", 2, "0_1_0", "0_1_1");
        assertNode(trees.get(0).getChildren().get(2), "0_2", 0);


        assertNode(trees.get(1), "1", 2, "1_0", "1_1");
        assertNode(trees.get(1).getChildren().get(0), "1_0", 0);
        assertNode(trees.get(1).getChildren().get(1), "1_1", 3, "1_1_0", "1_1_1", "1_1_2");


        assertNode(trees.get(2), "2", 1, "2_0");
        assertNode(trees.get(2).getChildren().get(0), "2_0", 0);
    }

    private void assertNode(Composite node, String id, int childCount, String... childIds) {
        assertThat("node id", node.getId(), is(id));
        List<Composite> children = node.getChildren();
        assertThat("children count", children.size(), is(childCount));
        for (String childId : childIds) {
            assertThat("should have children", children, hasItem(new Composite(childId)));
        }
    }

    private void assertNode(Composite node, String id, int childrenCount) {
        assertThat(node.getId(), is(id));
        assertThat(node.getChildren().size(), is(childrenCount));
    }

}

