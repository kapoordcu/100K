package gk.practic.problem;

import java.util.NavigableMap;
import java.util.TreeMap;

public interface ExchangeStrategy {
    Integer findCandidate(NavigableMap<Integer, Integer> inventory, int offer, int demand);
}
