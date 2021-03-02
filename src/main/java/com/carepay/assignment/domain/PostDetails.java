package com.carepay.assignment.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class PostDetails extends PostInfo {
    private String content;

}
