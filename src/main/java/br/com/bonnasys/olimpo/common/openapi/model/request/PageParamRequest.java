package br.com.bonnasys.olimpo.common.openapi.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record PageParamRequest(@Schema(example = "0")
                               int page,
                               @Schema(example = "10")
                               int size) {
}
