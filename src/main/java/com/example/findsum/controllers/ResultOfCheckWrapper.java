package com.example.findsum.controllers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class ResultOfCheckWrapper {
    private boolean result;
}
