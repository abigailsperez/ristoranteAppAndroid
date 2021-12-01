package com.example.ristorantehttp.model.entity

import java.util.*

data class Session(
    var id: Long,
    var date_session: Date,
    var in_out: Long,
    var use: Long,
    var user_session: Long
)
