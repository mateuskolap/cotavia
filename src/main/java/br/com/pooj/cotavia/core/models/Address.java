package br.com.pooj.cotavia.core.models;

public record Address(
    String street,
    String number,
    String city,
    String state,
    String country,
    String zipCode
) {}
