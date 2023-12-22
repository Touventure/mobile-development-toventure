package com.capston.touventure.data.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

	@field:SerializedName("CategoryResponse")
	val categoryResponse: List<CategoryResponseItem>? = null
)

data class CategoryResponseItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rating_ave")
	val ratingAve: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("y_p")
	val yP: String? = null,

	@field:SerializedName("category")
	val category: String? = null
)
