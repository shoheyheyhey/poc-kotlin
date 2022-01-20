package com.example.kotlindemo.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {
    @GetMapping("/health")
    fun health() :ResponseEntity<String> {
        return ResponseEntity.ok("UP")
    }

    @GetMapping("/hello")
    fun hello() :ResponseEntity<String> {
        return ResponseEntity.ok("HELLO")
    }

}
