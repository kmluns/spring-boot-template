package com.uns.template.utils.repository;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SearchCriteria<T> {

    private String path;

    private T value;

    private ComparatorType comparatorType;
}
