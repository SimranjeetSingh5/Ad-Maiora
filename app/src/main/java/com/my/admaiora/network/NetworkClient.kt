package com.my.admaiora.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

object NetworkClient {
    val client = HttpClient(Android) { install(JsonFeature) { serializer = KotlinxSerializer() } }
}