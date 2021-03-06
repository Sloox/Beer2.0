package com.wright.beers20.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ingredients {
    @SerializedName("malt")
    @Expose
    var malt: List<Malt>? = null

    @SerializedName("hops")
    @Expose
    var hops: List<Hop>? = null

    @SerializedName("yeast")
    @Expose
    var yeast: String? = null
}
