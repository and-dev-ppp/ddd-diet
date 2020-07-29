package com.example.clean_architecture_sample

import androidx.multidex.MultiDexApplication
import com.example.data.Database
import com.example.data.repositoryImpl.FatRepositoryImpl
import com.example.data.store.FatLocalDataStore
import com.example.domain.repository.FatRepository
import com.example.domain.usecase.FatUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class DietApplication : MultiDexApplication() {

    private val appModule = module {
        single<FatRepository> {
            FatRepositoryImpl(
                FatLocalDataStore(
                    Database.getInstance(applicationContext)
                )
            )
        }
        single<FatUseCase> { get() }
        viewModel<TopViewModel> { get() }
    }

    private val domainModule = module {
    }


    override fun onCreate() {
        Timber.d("APP onCreate")
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(appModule)
        }

        Timber.d("After startKoin")

    }
}