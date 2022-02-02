package com.example.hcacodingchallenge.models

data class MyData(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)