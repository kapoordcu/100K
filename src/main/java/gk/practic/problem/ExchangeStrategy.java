package gk.practic.problem;

import java.util.TreeMap;

public interface ExchangeStrategy {
    Integer findCandidate(TreeMap<Integer, Integer> inventory, int offer, int demand);
}
