package com.paranoidal97.ShoppingCartMicroservice.model.enums;

import com.paranoidal97.ShoppingCartMicroservice.exception.IllegalApointmentTransition;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@AllArgsConstructor
public enum CartStatus {
    UNPAID(Set.of("PAID"), Values.UNPAID),
    PAID(Set.of(), Values.PAID);

    private final Set<String> allowedTransitions;
    private String value;
    public boolean isTransitionAllowed(CartStatus cartStatus) {
        if (!(allowedTransitions.contains(cartStatus.toString()))) {
            throw new IllegalApointmentTransition(
                    "This status transition from state is illegal"
            );
        }
        return true;
    }

    public static CartStatus fromString(String text) {
        for (CartStatus status : CartStatus.values()) {
            if (status.value.equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid CartStatus value: " + text);
    }

    public static class Values {
        public static final String UNPAID = "UNPAID";
        public static final String PAID = "PAID";
    }
}
