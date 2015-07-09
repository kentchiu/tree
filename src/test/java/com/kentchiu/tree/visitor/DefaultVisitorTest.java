package com.kentchiu.tree.visitor;


import com.kentchiu.tree.domain.Composite;
import com.kentchiu.tree.domain.Composites;
import org.junit.Test;

import java.util.function.Function;

public class DefaultVisitorTest {

    @Test
    public void testDefaultVisitor() throws Exception {
        Composite root = Composites.root();
        Function<Composite, String> function = composite -> composite.getId();
        root.accept(new DefaultVisitor(function));
    }
}