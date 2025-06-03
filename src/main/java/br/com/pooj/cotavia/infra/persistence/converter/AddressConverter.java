package br.com.pooj.cotavia.infra.persistence.converter;

import br.com.pooj.cotavia.core.models.Address;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<Address, String> {
    private static final String SEPARATOR = "|";

    @Override
    public String convertToDatabaseColumn(Address address) {
        if (address == null) return null;

        return String.join(SEPARATOR,
            address.street(),
            address.number(),
            address.city(),
            address.state(),
            address.country(),
            address.zipCode());
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return null;

        String[] parts = dbData.split(SEPARATOR);

        return new Address(
            parts[0], // street
            parts[1], // number
            parts[2], // city
            parts[3], // state
            parts[4], // country
            parts[5]  // zipCode
        );
    }
}
