package com.example.islamic_project.apis.models

import com.google.gson.annotations.SerializedName

data class RadioResponse(

    @field:SerializedName("radios")
    val radios: List<RadioChannel?>? = null
)