package com.nextus.baseapp.data.model

data class User(val uid: String, val nickname: String, val imageUrl: String, val age: String, val gender: String,
                val email: String)

data class GistsPublic(val url: String, val forks_url: String)