package me.karolsteve.balancer;

import java.util.List;

/**
 * Created By Steve Tchatchouang
 * Date : 18/08/2024 08:15
 */
public interface LoadBalancer<T> {
    void update(List<T> list);

    T nextItem();

    default void setPreferredNodeID(Object preferredNodeID) {
        throw new UnsupportedOperationException();
    }
}
