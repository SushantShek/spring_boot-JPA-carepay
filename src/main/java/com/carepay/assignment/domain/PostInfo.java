package com.carepay.assignment.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PostInfo {
    private Long id;
    private String title;
}
