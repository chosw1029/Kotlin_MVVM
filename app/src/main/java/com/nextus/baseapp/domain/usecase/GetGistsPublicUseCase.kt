package com.nextus.baseapp.domain.usecase

import com.nextus.baseapp.domain.core.Result
import com.nextus.baseapp.domain.model.GistsPublic
import com.nextus.baseapp.domain.repository.GitRepository

class GetGistsPublicUseCase(private val gitRepository: GitRepository) {
    suspend operator fun invoke(): Result<List<GistsPublic>> {
        return gitRepository.getGistsPublic()
    }
}