package com.kentchiu.tree.visitor;

import com.kentchiu.tree.domain.Composite;
import com.kentchiu.tree.domain.Composites;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LeafVisitorTest {

    @Test
    public void testGetLeaves() throws Exception {
        Composite root = Composites.root();
        LeafVisitor<Composite> visitor = new LeafVisitor<>();
        root.accept(visitor);
        assertThat(visitor.getLeaves().size(), is(33));
        assertThat(visitor.getLeaves().get(0).getId(), is("0_0_0_0"));
        assertThat(visitor.getLeaves().get(1).getId(), is("0_0_0_1"));
        assertThat(visitor.getLeaves().get(2).getId(), is("0_0_0_2"));
        assertThat(visitor.getLeaves().get(3).getId(), is("0_0_0_3"));
        assertThat(visitor.getLeaves().get(4).getId(), is("0_0_1_0"));
        assertThat(visitor.getLeaves().get(5).getId(), is("0_0_1_1"));
        assertThat(visitor.getLeaves().get(6).getId(), is("0_0_1_2"));
        assertThat(visitor.getLeaves().get(7).getId(), is("0_0_1_3"));
        assertThat(visitor.getLeaves().get(8).getId(), is("0_0_2_0"));
        assertThat(visitor.getLeaves().get(9).getId(), is("0_0_2_1"));
        assertThat(visitor.getLeaves().get(10).getId(), is("0_0_2_2"));
        assertThat(visitor.getLeaves().get(11).getId(), is("0_0_2_3"));
        assertThat(visitor.getLeaves().get(12).getId(), is("0_0_3"));
        assertThat(visitor.getLeaves().get(13).getId(), is("0_1_0"));
        assertThat(visitor.getLeaves().get(14).getId(), is("0_1_1"));
        assertThat(visitor.getLeaves().get(15).getId(), is("0_1_2"));
        assertThat(visitor.getLeaves().get(16).getId(), is("0_1_3"));
        assertThat(visitor.getLeaves().get(17).getId(), is("0_2_0"));
        assertThat(visitor.getLeaves().get(18).getId(), is("0_2_1"));
        assertThat(visitor.getLeaves().get(19).getId(), is("0_2_2"));
        assertThat(visitor.getLeaves().get(20).getId(), is("0_2_3"));
        assertThat(visitor.getLeaves().get(21).getId(), is("0_3"));
        assertThat(visitor.getLeaves().get(22).getId(), is("1_0"));
        assertThat(visitor.getLeaves().get(23).getId(), is("1_1"));
        assertThat(visitor.getLeaves().get(24).getId(), is("1_2"));
        assertThat(visitor.getLeaves().get(25).getId(), is("1_3"));
        assertThat(visitor.getLeaves().get(26).getId(), is("2_0"));
        assertThat(visitor.getLeaves().get(27).getId(), is("2_1"));
        assertThat(visitor.getLeaves().get(28).getId(), is("2_2"));
        assertThat(visitor.getLeaves().get(29).getId(), is("2_3"));
        assertThat(visitor.getLeaves().get(30).getId(), is("3"));
        assertThat(visitor.getLeaves().get(31).getId(), is("4"));
        assertThat(visitor.getLeaves().get(32).getId(), is("5"));
    }
}