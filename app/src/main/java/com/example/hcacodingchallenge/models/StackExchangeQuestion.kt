package com.example.hcacodingchallenge.models

data class StackExchangeQuestion (
    var title: String,
    var createdBy: String,
    var answer_count: Int,
    var is_answered: Boolean,
    var questionID: Int){


}