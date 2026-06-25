package gk.practic.problem;

import java.util.TreeMap;

public class PawnShop {
    private final TreeMap<Integer, Integer> inventory;
    private final ExchangeStrategy strategy;

    public PawnShop(int size, ExchangeStrategy strategy) {
        this.strategy = strategy;
        inventory = new TreeMap<>();
        if (size > 0) {
            inventory.put(1, size); // all `size` objects start at value 1
        }
    }


    public PawnResponse objectExchange(int offer, int demand) {
        PawnResponse response;
        // Log incoming request and inventory state
        System.out.println(
                "Request => offer=" + offer +
                        ", demand=" + demand +
                        ", inventory=" + inventory
        );
        // Sanity check
        if (demand >= offer) {
            response = PawnResponse.reject();
        } else {
            Integer candidate = strategy.findCandidate(inventory, offer, demand);
            if (candidate == null) {
                response = PawnResponse.reject();
            } else {
                removeOne(candidate);
                addOne(offer);
                response = PawnResponse.accept(candidate);
            }
        }
        // Log outgoing response and inventory state
        System.out.println(
                "Response => " + response.getState() +
                        ", inventory=" + inventory
        );
        return response;
    }

    private void removeOne(int value) {
        int count = inventory.get(value);
        if (count == 1) {
            inventory.remove(value);
        } else {
            inventory.put(value, count - 1);
        }
    }

    private void addOne(int value) {
        inventory.merge(value, 1, Integer::sum);
    }

    public static void main(String[] args) {
        PawnShop pawnShop = new PawnShop(5, new MaxExchangeStrategy());
        pawnShop.objectExchange(5, -2);
        pawnShop.objectExchange(2, 3);
        pawnShop.objectExchange(2, 1);
        pawnShop.objectExchange(4, 3);
        pawnShop.objectExchange(4, 1);
    }
}