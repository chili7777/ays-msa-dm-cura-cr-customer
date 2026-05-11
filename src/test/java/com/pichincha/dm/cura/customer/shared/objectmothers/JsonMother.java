package com.pichincha.dm.cura.customer.shared.objectmothers;

/**
 * Utility mother for generating JSON strings for test payloads.
 * Helps in creating consistent JSON structures for API request and response verification.
 */
public final class JsonMother {

    private JsonMother() {
    }

    public static String toJson(Object object) {
        // For simplicity in this project, we might use a library like Jackson
        // or just return a pre-formatted string if needed.
        // For now, this is a placeholder or used for specific string transformations.
        return object.toString();
    }

}