package com.vendasse.dtos.user;

import com.vendasse.enums.Role;

public record RegisterDTO(String email, String password, String name, Role role) {


}
