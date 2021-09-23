package com.wright.beers20.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BoilVolume {
    @SerializedName("value")
    @Expose
    var value: Int? = null

    @SerializedName("unit")
    @Expose
    var unit: String? = null
}
