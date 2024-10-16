package me.karolsteve.balancer.internal;

import me.karolsteve.balancer.IdentifiableNode;
import me.karolsteve.balancer.LoadBalancer;

import java.util.*;

/**
 * Created By Steve Tchatchouang
 * Date : 14/09/2024 09:09
 */

public class LocalFirstLoadBalancer<T> implements LoadBalancer<T> {
    private final Map<Object, T> nodesById = new HashMap<>();
    private List<T> nodes = new ArrayList<>();

    private Object preferredNodeId;

    //for fallback round-robin
    private int lastIndex = 0;

    @Override
    public void update(List<T> list) {
        this.nodes = list;
        this.nodesById.clear();
        list.forEach(n -> {
            if (n instanceof IdentifiableNode identifiableNode) {
                this.nodesById.put(identifiableNode.getId(), n);
            } else {
                throw new IllegalArgumentException("Not a IdentifiableNode: " + n);
            }
        });
    }

    @Override
    public void setPreferredNodeID(Object preferredNodeID) {
        this.preferredNodeId = preferredNodeID;
    }

    @Override
    public T nextItem() {
        Objects.requireNonNull(preferredNodeId, "You must provide a valid preferred node id");
        if (nodes.isEmpty()) {
            return null;
        }
        T result = nodesById.get(preferredNodeId);
        if (result == null) {
            result = nodes.get(++lastIndex % nodes.size());
        }
        return result;
    }
}
