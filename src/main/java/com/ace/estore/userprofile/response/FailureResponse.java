package com.ace.estore.userprofile.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public record FailureResponse(@JsonInclude(Include.NON_EMPTY) List<String> errors,
		@JsonInclude(Include.NON_EMPTY) List<String> warnings) {

}
