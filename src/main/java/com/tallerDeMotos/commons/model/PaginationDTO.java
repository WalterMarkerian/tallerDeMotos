package com.tallermecanico.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDTO {
    @Schema(description = "total pages", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1")
    @JsonProperty(value = "pages")
    Integer pages;
    @Schema(description = "total elements", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "2")
    @JsonProperty(value = "count")
    Integer count;
    @Schema(description = "current page", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1")
    @JsonProperty(value = "page")
    Integer page;
}
