package gk.practic.cint;

import java.util.Arrays;

public class PawnShop {

    private final int[] inventory;

    public PawnShop(int size) {
        inventory = new int[size];

        for (int i = 0; i < size; i++) {
            inventory[i] = 1;
        }
    }

    public PawnResponse objectExchange(int offer, int demand) {
        PawnResponse response;
        // Log incoming request and inventory state
        System.out.println(
                "Request => offer=" + offer +
                        ", demand=" + demand +
                        ", inventory=" + Arrays.toString(inventory)
        );
        // Sanity check
        if (demand >= offer) {
            response = PawnResponse.reject();
        } else {
            int candidateIndex = -1;
            int candidateValue = Integer.MAX_VALUE;
            for (int i = 0; i < inventory.length; i++) {
                int item = inventory[i];
                if (item >= demand && item < offer) {
                    if (item < candidateValue) {
                        candidateValue = item;
                        candidateIndex = i;
                    }
                }
            }
            if (candidateIndex == -1) {
                response = PawnResponse.reject();
            } else {
                inventory[candidateIndex] = offer;
                response = PawnResponse.accept(candidateValue);
            }
        }
        // Log outgoing response and inventory state
        System.out.println(
                "Response => " + response.getCode() +
                        ", inventory=" + Arrays.toString(inventory)
        );
        return response;
    }

    public static void main(String[] args) {
        PawnShop pawnShop = new PawnShop(2);
        pawnShop.objectExchange(5, -2);
        pawnShop.objectExchange(2, 3);
        pawnShop.objectExchange(2, 1);
        pawnShop.objectExchange(4, 3);
    }
}