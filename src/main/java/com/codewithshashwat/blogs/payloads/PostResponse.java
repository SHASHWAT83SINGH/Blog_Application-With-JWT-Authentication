package com.codewithshashwat.blogs.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
 private List<PostDto> content;
 private Integer pageNumber;
 private Integer pageSize;
 private Long totalElements;
 private Integer totalPage;
 
 private boolean LastPage;
}
