package com.topay.users.infra.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.topay.users.infra.serializer.PageWrapperSerializer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 03/05/2020
 */
@AllArgsConstructor
@JsonSerialize(using = PageWrapperSerializer.class)
public class PageWrapper<E extends Page> {

    private final Page<E> page;

    /**
     * @return
     */
    public List<E> getContent() {
        final List<E> content = page.getContent();
        return Collections.unmodifiableList(content);
    }

    /**
     * @return
     */
    public Integer getActualPage() {
        return page.getNumber();
    }

    /**
     * @return
     */
    public Integer getTotalOfPages() {
        return page.getTotalPages();
    }

    /**
     *
     * @return
     */
    public Integer getPageSize() {
        return page.getSize();
    }

}
