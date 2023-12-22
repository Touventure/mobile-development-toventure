package com.capston.touventure.data.response

import com.google.gson.annotations.SerializedName

data class NearestResponse(

	@field:SerializedName("NearestResponse")
	val nearestResponse: List<NearestResponseItem?>? = null
)

data class NearestResponseItem(

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
