package org.chefk5.pizzashop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRequest(

        @NotNull
        String username,

        @Email
        @NotNull
        String email,

        @NotNull
        String password


) {
}
