package me.karolsteve.balancer.internal;

import me.karolsteve.balancer.LoadBalancer;

import java.util.List;

/**
 * Created By Steve Tchatchouang
 * Date : 18/08/2024 08:20
 */
public class RoundRobinLoadBalancer<T> implements LoadBalancer<T> {
    private int index = 0;
    private List<T> list;

    @Override
    public void update(List<T> list) {
        this.list = list;
    }

    @Override
    public T nextItem() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(++index % list.size());
    }
}
