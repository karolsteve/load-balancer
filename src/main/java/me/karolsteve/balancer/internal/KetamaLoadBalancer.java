package me.karolsteve.balancer.internal;

import me.karolsteve.balancer.LoadBalancer;

import java.util.List;

/**
 * Created By Steve Tchatchouang
 * Date : 18/08/2024 08:35
 */
public class KetamaLoadBalancer<T> implements LoadBalancer<T> {

    @Override
    public void update(List<T> list) {

    }

    @Override
    public T nextItem() {
        return null;
    }
}
