package com.ace.estore.userprofile.request.dto;

import lombok.Builder;

@Builder
public record CredentialsDto(String username, String password) {

}
