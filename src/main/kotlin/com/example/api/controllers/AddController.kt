package com.example.api.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("api/v1")
class AddController {
    // post, get, put, delete,
    @PostMapping("/add", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun add(@RequestBody numbers: Numbers): Int {
        return sum(numbers.list)
    }

    fun sum(numbers: List<Int>): Int {
        Logger.getLogger("AddController").info("Adding numbers together successfully!!")
        var sum = 0
        for (number in numbers) {
            sum += number
        }
        return sum
    }
}

data class Numbers(val list: List<Int>)

/*
{
	"list": [1,2,3,4]
}
 */