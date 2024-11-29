package com.episodios.cascaparomarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterDTO {
    String username;
    String password;
    String fistName;
    String lastName;
}
