package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerCreateRequestDto;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerPatchRequestDto;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerUpdateRequestDto;

public final class JsonMother {

    private JsonMother() {
    }

    public static String fromObject(Object value) {
        if (value instanceof CustomerCreateRequestDto customerCreateRequestDto) {
            return fromCustomerCreateRequestDto(customerCreateRequestDto);
        }
        if (value instanceof CustomerUpdateRequestDto customerUpdateRequestDto) {
            return fromCustomerUpdateRequestDto(customerUpdateRequestDto);
        }
        if (value instanceof CustomerPatchRequestDto customerPatchRequestDto) {
            return fromCustomerPatchRequestDto(customerPatchRequestDto);
        }
        throw new IllegalArgumentException("Unsupported object type for JsonMother: " + value.getClass().getName());
    }

    private static String fromCustomerCreateRequestDto(CustomerCreateRequestDto dto) {
        return "{" +
                "\"name\":\"" + dto.getName() + "\"," +
                "\"gender\":\"" + dto.getGender().getValue() + "\"," +
                "\"age\":" + dto.getAge() + "," +
                "\"identification\":\"" + dto.getIdentification() + "\"," +
                "\"address\":\"" + dto.getAddress() + "\"," +
                "\"phone\":\"" + dto.getPhone() + "\"," +
                "\"email\":\"" + dto.getEmail() + "\"," +
                "\"password\":\"" + dto.getPassword() + "\"," +
                "\"status\":" + dto.getStatus() +
                "}";
    }

    private static String fromCustomerUpdateRequestDto(CustomerUpdateRequestDto dto) {
        return "{" +
                "\"name\":\"" + dto.getName() + "\"," +
                "\"gender\":\"" + dto.getGender().getValue() + "\"," +
                "\"age\":" + dto.getAge() + "," +
                "\"identification\":\"" + dto.getIdentification() + "\"," +
                "\"address\":\"" + dto.getAddress() + "\"," +
                "\"phone\":\"" + dto.getPhone() + "\"," +
                "\"email\":\"" + dto.getEmail() + "\"," +
                "\"password\":\"" + dto.getPassword() + "\"," +
                "\"status\":" + dto.getStatus() +
                "}";
    }

    private static String fromCustomerPatchRequestDto(CustomerPatchRequestDto dto) {
        StringBuilder json = new StringBuilder("{");
        boolean first = true;
        if (dto.getName() != null) {
            json.append("\"name\":\"").append(dto.getName()).append("\"");
            first = false;
        }
        if (dto.getGender() != null) {
            if (!first) json.append(",");
            json.append("\"gender\":\"").append(dto.getGender().getValue()).append("\"");
            first = false;
        }
        if (dto.getAge() != null) {
            if (!first) json.append(",");
            json.append("\"age\":").append(dto.getAge());
            first = false;
        }
        if (dto.getIdentification() != null) {
            if (!first) json.append(",");
            json.append("\"identification\":\"").append(dto.getIdentification()).append("\"");
            first = false;
        }
        if (dto.getAddress() != null) {
            if (!first) json.append(",");
            json.append("\"address\":\"").append(dto.getAddress()).append("\"");
            first = false;
        }
        if (dto.getPhone() != null) {
            if (!first) json.append(",");
            json.append("\"phone\":\"").append(dto.getPhone()).append("\"");
            first = false;
        }
        if (dto.getPassword() != null) {
            if (!first) json.append(",");
            json.append("\"password\":\"").append(dto.getPassword()).append("\"");
            first = false;
        }
        if (dto.getStatus() != null) {
            if (!first) json.append(",");
            json.append("\"status\":").append(dto.getStatus());
        }
        json.append("}");
        return json.toString();
    }
}