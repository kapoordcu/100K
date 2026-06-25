package gk.practic.problem;

import java.util.TreeMap;

public class MaxExchangeStrategy implements ExchangeStrategy {
    @Override
    public Integer findCandidate(TreeMap<Integer, Integer> inventory, int offer, int demand) {
        Integer candidate = inventory.ceilingKey(demand);
        if (candidate == null || candidate >= offer) {
            return null;
        }
        return candidate;
    }
}
