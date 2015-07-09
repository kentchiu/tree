package com.kentchiu.tree.visitor;

import com.kentchiu.tree.domain.Composite;
import com.kentchiu.tree.domain.Composites;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TreePrintVisitorTest {

    @Test
    public void testDumpTree() throws Exception {
        Function<Composite, String> function = composite -> composite.getId();
        TreePrintVisitor<Composite> visitor = new TreePrintVisitor<>(function);
        Composites.root().accept(visitor);
        List<String> lines = visitor.getLines();

        int i = 0;
        assertThat(lines.get(i++), is(" ├─ root"));
        assertThat(lines.get(i++), is(" │  ├─ 0"));
        assertThat(lines.get(i++), is(" │  │  ├─ 0_0"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_0_0"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_0_0"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_0_1"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_0_2"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_0_3"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_0_1"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_1_0"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_1_1"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_1_2"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_1_3"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_0_2"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_2_0"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_2_1"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_2_2"));
        assertThat(lines.get(i++), is(" │  │  │  │  ├─ 0_0_2_3"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_0_3"));
        assertThat(lines.get(i++), is(" │  │  ├─ 0_1"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_1_0"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_1_1"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_1_2"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_1_3"));
        assertThat(lines.get(i++), is(" │  │  ├─ 0_2"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_2_0"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_2_1"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_2_2"));
        assertThat(lines.get(i++), is(" │  │  │  ├─ 0_2_3"));
        assertThat(lines.get(i++), is(" │  │  ├─ 0_3"));
        assertThat(lines.get(i++), is(" │  ├─ 1"));
        assertThat(lines.get(i++), is(" │  │  ├─ 1_0"));
        assertThat(lines.get(i++), is(" │  │  ├─ 1_1"));
        assertThat(lines.get(i++), is(" │  │  ├─ 1_2"));
        assertThat(lines.get(i++), is(" │  │  ├─ 1_3"));
        assertThat(lines.get(i++), is(" │  ├─ 2"));
        assertThat(lines.get(i++), is(" │  │  ├─ 2_0"));
        assertThat(lines.get(i++), is(" │  │  ├─ 2_1"));
        assertThat(lines.get(i++), is(" │  │  ├─ 2_2"));
        assertThat(lines.get(i++), is(" │  │  ├─ 2_3"));
        assertThat(lines.get(i++), is(" │  ├─ 3"));
        assertThat(lines.get(i++), is(" │  ├─ 4"));
        assertThat(lines.get(i++), is(" │  ├─ 5"));
    }
}