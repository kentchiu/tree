package com.kentchiu.tree.domain;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class Composites {
    private Composites() {
    }


    private static Composite createWithChildren(Composite composite, String... children) {
        for (String child : children) {
            composite.addChild(new Composite(child));
        }
        return composite;
    }

    /**
     * ├─ root
     * │  ├─ 0
     * │  │  ├─ 0_0
     * │  │  │  ├─ 0_0_0
     * │  │  │  │  ├─ 0_0_0_0 ........ path 0
     * │  │  │  │  ├─ 0_0_0_1
     * │  │  │  │  ├─ 0_0_0_2
     * │  │  │  │  ├─ 0_0_0_3 ........ path 3
     * │  │  │  ├─ 0_0_1
     * │  │  │  │  ├─ 0_0_1_0 ........ path 4
     * │  │  │  │  ├─ 0_0_1_1
     * │  │  │  │  ├─ 0_0_1_2
     * │  │  │  │  ├─ 0_0_1_3 ........ path 7
     * │  │  │  ├─ 0_0_2
     * │  │  │  │  ├─ 0_0_2_0 ........ path 8
     * │  │  │  │  ├─ 0_0_2_1
     * │  │  │  │  ├─ 0_0_2_2
     * │  │  │  │  ├─ 0_0_2_3 ........ path 11
     * │  │  │  ├─ 0_0_3 ............. path 12
     * │  │  ├─ 0_1
     * │  │  │  ├─ 0_1_0 ............. path 13
     * │  │  │  ├─ 0_1_1
     * │  │  │  ├─ 0_1_2
     * │  │  │  ├─ 0_1_3 ............. path 16
     * │  │  ├─ 0_2
     * │  │  │  ├─ 0_2_0 ............. path 17
     * │  │  │  ├─ 0_2_1
     * │  │  │  ├─ 0_2_2
     * │  │  │  ├─ 0_2_3 ............. path 20
     * │  │  ├─ 0_3 .................. path 21
     * │  ├─ 1
     * │  │  ├─ 1_0 .................. path 22
     * │  │  ├─ 1_1
     * │  │  ├─ 1_2
     * │  │  ├─ 1_3 .................. path 25
     * │  ├─ 2
     * │  │  ├─ 2_0 .................. path 26
     * │  │  ├─ 2_1
     * │  │  ├─ 2_2
     * │  │  ├─ 2_3 .................. path 29
     * │  ├─ 3  ...................... path 30
     * │  ├─ 4
     * │  ├─ 5  ...................... path 32
     */
    public static Composite root() {
        Composite root = new Composite("root");
        createWithChildren(root, "0", "1", "2", "3", "4", "5");

        Composite c_0 = root.getChildren().get(0);
        createWithChildren(c_0, "0_0", "0_1", "0_2", "0_3");

        Composite c_1 = root.getChildren().get(1);
        createWithChildren(c_1, "1_0", "1_1", "1_2", "1_3");


        Composite c_2 = root.getChildren().get(2);
        createWithChildren(c_2, "2_0", "2_1", "2_2", "2_3");

        Composite c_0_0 = c_0.getChildren().get(0);
        createWithChildren(c_0_0, "0_0_0", "0_0_1", "0_0_2", "0_0_3");

        Composite c_0_1 = c_0.getChildren().get(1);
        createWithChildren(c_0_1, "0_1_0", "0_1_1", "0_1_2", "0_1_3");

        Composite c_0_2 = c_0.getChildren().get(2);
        createWithChildren(c_0_2, "0_2_0", "0_2_1", "0_2_2", "0_2_3");


        Composite c_0_0_0 = c_0_0.getChildren().get(0);
        createWithChildren(c_0_0_0, "0_0_0_0", "0_0_0_1", "0_0_0_2", "0_0_0_3");

        Composite c_0_0_1 = c_0_0.getChildren().get(1);
        createWithChildren(c_0_0_1, "0_0_1_0", "0_0_1_1", "0_0_1_2", "0_0_1_3");

        Composite c_0_0_2 = c_0_0.getChildren().get(2);
        createWithChildren(c_0_0_2, "0_0_2_0", "0_0_2_1", "0_0_2_2", "0_0_2_3");
        return root;
    }

    public static Optional<Composite> findByPath(Composite c, int... positions) {
        Optional<Composite> optional = Optional.ofNullable(Iterables.get(c.getChildren(), positions[0]));
        Composites cs = new Composites();
        return cs.getComposite(optional, 1, positions);
    }


    public static List<Composite> all() {
        Composite tree_0 = createComposite(null, "0");

        Composite tree_0_0 = createComposite(tree_0, "0_0");
        Composite tree_0_0_0 = createComposite(tree_0_0, "0_0_0");
        Composite tree_0_0_1 = createComposite(tree_0_0, "0_0_1");
        Composite tree_0_0_2 = createComposite(tree_0_0, "0_0_2");

        Composite tree_0_1 = createComposite(tree_0, "0_1");
        Composite tree_0_1_0 = createComposite(tree_0_1, "0_1_0");
        Composite tree_0_1_1 = createComposite(tree_0_1, "0_1_1");

        Composite tree_0_2 = createComposite(tree_0, "0_2");

        Composite tree_1 = createComposite(null, "1");

        Composite tree_1_0 = createComposite(tree_1, "1_0");

        Composite tree_1_1 = createComposite(tree_1, "1_1");

        Composite tree_1_1_0 = createComposite(tree_1_1, "1_1_0");
        Composite tree_1_1_1 = createComposite(tree_1_1, "1_1_1");
        Composite tree_1_1_2 = createComposite(tree_1_1, "1_1_2");

        Composite tree_2 = createComposite(null, "2");

        Composite tree_2_0 = createComposite(tree_2, "2_0");

        // add item without ordered
        List<Composite> results = Lists.newArrayList();
        results.add(tree_0);
        results.add(tree_0_0);
        results.add(tree_0_0_0);
        results.add(tree_0_0_1);
        results.add(tree_0_0_2);
        results.add(tree_0_1);
        results.add(tree_0_1_0);
        results.add(tree_0_1_1);
        results.add(tree_0_2);

        results.add(tree_1);
        results.add(tree_1_0);
        results.add(tree_1_1);
        results.add(tree_1_1_0);
        results.add(tree_1_1_1);
        results.add(tree_1_1_2);

        results.add(tree_2);
        results.add(tree_2_0);
        return results;

    }

    private static Composite createComposite(Composite parent, String childId) {
        Composite composite = new Composite(childId);
        composite.setParent(parent);
        return composite;
    }

    private Optional<Composite> getComposite(Optional<Composite> optional, int index, int... positions) {
        if (index < positions.length - 1) {
            Optional<Composite> x = Optional.ofNullable(Iterables.get(optional.get().getChildren(), positions[index]));
            return getComposite(x, index + 1, positions);
        } else {
            return Optional.ofNullable(Iterables.get(optional.get().getChildren(), positions[index]));
        }
    }
}