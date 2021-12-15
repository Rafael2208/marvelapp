package com.example.marvelapp.model

import java.lang.Character

data class Data(
    var offset  : Int? = null,
    var limit   : Int?              = null,
    var total   : Int?              = null,
    var count   : Int?              = null,
    var results : List<Character>? = null

){
    override fun toString(): String {
        return "$count"
    }
}