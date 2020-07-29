package com.example.clean_architecture_sample

import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.example.data.Database
import com.example.data.FatDatabase
import com.example.data.repositoryImpl.FatRepositoryImpl
import com.example.data.store.FatLocalDataStore
import com.example.domain.repository.FatRepository
import com.example.domain.usecase.FatUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

class DietApplication : MultiDexApplication() {

    private val appModule = module {
        /*
        scope<MainActivity>() {
            scoped { FatUseCase(get()) }
        }
         */
        single { FatUseCase(get()) }
    }

    private val domainModule = module {
        // define any other modules if any.
        single<FatRepository> {
            FatRepositoryImpl(
                FatLocalDataStore(
                    Database.getInstance(applicationContext)
                ))
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(appModule, domainModule))
        }
    }
}