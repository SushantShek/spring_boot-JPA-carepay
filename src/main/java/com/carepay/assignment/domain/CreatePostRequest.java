package com.carepay.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
    @NotNull
    @Size(max = 128)
    private String title;

    @NotNull
    @Size(max = 128)
    private String content;
}