package com.wright.beers20.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Malt {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("amount")
    @Expose
    var amount: Amount? = null
}
