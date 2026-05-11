package com.pichincha.dm.cura.customer.shared.objectmothers;

import org.springframework.http.HttpHeaders;

/**
 * Utility mother for HTTP headers.
 * Generates common headers like X-Guid and X-App for API requests.
 */
public final class HttpHeadersMother {

    private HttpHeadersMother() {
    }

    public static HttpHeaders standard() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Guid", UuidMother.random());
        headers.add("X-App", "test-app");
        return headers;
    }

}