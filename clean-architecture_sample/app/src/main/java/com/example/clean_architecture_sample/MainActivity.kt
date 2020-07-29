package com.example.clean_architecture_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.clean_architecture_sample.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<TopViewModel>()
//    private val fatUseCase by lifecycleScope.inject<FatUseCase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("Main onCreate")
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        CoroutineScope(Dispatchers.IO).launch {
//            fatUseCase.insert(75F)
//        }
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

//        CoroutineScope(Dispatchers.IO).launch {
//            Database.getInstance(applicationContext).fatDao().insertFatEntity(FatEntity(id = 0, createDate = Date().time, updateDate = Date().time, weight = 75F))
//        }
    }
}
