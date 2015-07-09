package com.kentchiu.tree.domain;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class PathTest {

    @Test
    public void testFromLeafNode() throws Exception {
        Composite root = Composites.root();

        List<Path<Composite>> paths = Path.buildFormTreeRoot(root);
        assertThat(paths.size(), is(33));

        // path 0: root -> 0 -> 0_0 -> 0_0_0 -> 0_0_0_0
        assertThat(paths.get(0).segments().size(), is(5));
        assertThat(paths.get(0).head().getId(), is("root"));
        assertThat(paths.get(0).tail().getId(), is("0_0_0_0"));
        assertThat(paths.get(0).segment(0).getId(), is("root"));
        assertThat(paths.get(0).segment(1).getId(), is("0"));
        assertThat(paths.get(0).segment(2).getId(), is("0_0"));
        assertThat(paths.get(0).segment(3).getId(), is("0_0_0"));
        assertThat(paths.get(0).segment(4).getId(), is("0_0_0_0"));

        // path 29: root -> 2 -> 2_3
        assertThat(paths.get(29).segments().size(), is(3));
        assertThat(paths.get(29).head().getId(), is("root"));
        assertThat(paths.get(29).tail().getId(), is("2_3"));
        assertThat(paths.get(29).segment(0).getId(), is("root"));
        assertThat(paths.get(29).segment(1).getId(), is("2"));
        assertThat(paths.get(29).segment(2).getId(), is("2_3"));

        // path 30: root -> 3
        assertThat(paths.get(30).segments().size(), is(2));
        assertThat(paths.get(30).head().getId(), is("root"));
        assertThat(paths.get(30).tail().getId(), is("3"));
        assertThat(paths.get(30).segment(0).getId(), is("root"));
        assertThat(paths.get(30).segment(1).getId(), is("3"));
    }
}