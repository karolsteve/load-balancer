package me.karolsteve.balancer;

import me.karolsteve.balancer.internal.KetamaLoadBalancer;
import me.karolsteve.balancer.internal.LocalFirstLoadBalancer;
import me.karolsteve.balancer.internal.RoundRobinLoadBalancer;

/**
 * Created By Steve Tchatchouang
 * Date : 18/08/2024 08:30
 */

public class LoadBalancerFactory {
    private LoadBalancerFactory() {
    }

    public static <T> LoadBalancer<T> create(String balancerName) {
        return switch (balancerName) {
            case "round_robin" -> new RoundRobinLoadBalancer<>();
            case "ketama" -> new KetamaLoadBalancer<>();
            case "local_first" -> new LocalFirstLoadBalancer<>();
            default -> throw new IllegalArgumentException("Unknown balancer name: " + balancerName);
        };
    }
}
