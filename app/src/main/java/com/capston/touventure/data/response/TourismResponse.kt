package com.capston.touventure.data.response

import com.google.gson.annotations.SerializedName

data class TourismResponse(

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Data(

	@field:SerializedName("Description")
	val description: String? = null,

	@field:SerializedName("Category")
	val category: String,

	@field:SerializedName("Place_Name")
	val placeName: String? = null,

	@field:SerializedName("Rating")
	val rating: String? = null,

	@field:SerializedName("City")
	val city: String? = null,

	@field:SerializedName("Time_Minutes")
	val timeMinutes: String? = null,

	@field:SerializedName("field12")
	val field12: String? = null,

	@field:SerializedName("Place_Id")
	val placeId: String? = null,

	@field:SerializedName("Price")
	val price: String? = null,

	@field:SerializedName("Coordinate")
	val coordinate: String? = null,

	@field:SerializedName("field13")
	val field13: String? = null,

	@field:SerializedName("Long")
	val long: String? = null,

	@field:SerializedName("Lat")
	val lat: String? = null
)

data class DataItem(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("id")
	val id: String? = null
)
