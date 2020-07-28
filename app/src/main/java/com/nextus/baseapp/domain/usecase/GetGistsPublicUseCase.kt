package com.nextus.baseapp.domain.usecase

import com.nextus.baseapp.domain.repository.GitRepository

class GetGistsPublicUseCase(private val gitRepository: GitRepository) {
    operator fun invoke() = gitRepository.getGistsPublic()
}