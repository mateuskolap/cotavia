package br.com.pooj.cotavia.infra.persistence.entities;

import java.math.BigDecimal;

import br.com.pooj.cotavia.core.models.Address;
import br.com.pooj.cotavia.infra.persistence.converter.AddressConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "destinations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(columnDefinition = "TEXT")
    @Convert(converter = AddressConverter.class)
    private Address address;

    @Column(nullable = false)
    private BigDecimal pricePerPerson;
}
