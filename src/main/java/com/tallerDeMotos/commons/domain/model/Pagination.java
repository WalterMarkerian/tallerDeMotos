package com.tallermecanico.commons.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pagination {
    Integer pages;
    Long count;
    Integer page;
}
