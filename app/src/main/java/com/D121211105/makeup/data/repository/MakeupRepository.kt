package com.D121211105.makeup.data.repository

import com.D121211105.makeup.data.response.GetMakeupResponse
import com.D121211105.makeup.data.source.remote.ApiService

class MakeupRepository(private val apiService: ApiService) {

    suspend fun getMakeup(): GetMakeupResponse {
        return apiService.getMakeup()
    }
}