package com.pada.learnproject.example.service.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record ManyToOneResponse(Long id, String manyToOneName) {
}
