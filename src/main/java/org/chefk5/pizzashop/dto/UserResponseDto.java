package org.chefk5.pizzashop.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserResponseDto(

        @NotNull
        String email,

        @NotNull
        String username
) {
}
