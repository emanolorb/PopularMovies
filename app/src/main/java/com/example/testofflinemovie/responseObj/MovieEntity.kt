package com.example.testofflinemovie.responseObj

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */

// Tambien se creara a manera de una entity

data class MovieEntity (
	@SerializedName("id") val id : Int,
	@SerializedName("poster_path") val poster_path : String,
	@SerializedName("adult") val adult : Boolean,
	@SerializedName("overview") val overview : String,
	@SerializedName("release_date") val release_date : String,
	@SerializedName("genre_ids") val genre_ids : List<Int>,
	@SerializedName("original_title") val original_title : String,
	@SerializedName("original_language") val original_language : String,
	@SerializedName("title") val title : String,
	@SerializedName("backdrop_path") val backdrop_path : String,
	@SerializedName("popularity") val popularity : Double,
	@SerializedName("vote_count") val vote_count : Int,
	@SerializedName("video") val video : Boolean,
	@SerializedName("vote_average") val vote_average : Double
)