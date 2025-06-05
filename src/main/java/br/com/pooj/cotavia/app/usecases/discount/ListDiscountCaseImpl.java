package br.com.pooj.cotavia.app.usecases.discount;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;
import br.com.pooj.cotavia.api.mappers.DiscountDtoMapper;
import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.ListDiscountCase;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListDiscountCaseImpl implements ListDiscountCase {
    private final DiscountRepository discountRepository;

    private final DiscountDtoMapper discountDtoMapper;

    @Override
    public List<DiscountResponseDto> execute() {
        return discountRepository.findAll()
                .stream()
                .map(discountDtoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
