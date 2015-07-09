package com.kentchiu.tree.domain;

/**
 * 結構型的visitor，可以更細精的控制Tree的 Traveling.
 *
 * @see <a>http://c2.com/cgi/wiki?HierarchicalVisitorPattern</a>
 */
public interface Visitor<T extends Node> {
    /**
     * 進入控制點，可以控制要不要進入節點處理
     *
     * @param node
     * @return
     */
    boolean visitEnter(T node);

    /**
     * 離開時會呼叫這個method
     *
     * @param node
     * @return
     */
    boolean visitLeave(T node);

    /**
     * 進行 visiting 的動作
     *
     * @param node
     * @return
     */
    boolean visit(T node);
}
