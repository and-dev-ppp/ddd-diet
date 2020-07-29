package com.example.clean_architecture_sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.clean_architecture_sample.databinding.ActivityMainBinding
import com.example.data.Database
import com.example.data.FatDatabase
import com.example.data.FatEntity
import com.example.domain.usecase.FatUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.currentScope
import org.koin.androidx.scope.lifecycleScope
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private val viewModel: TopViewModel by inject()
    private val fatUseCase by inject<FatUseCase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            fatUseCase.insert(75F)
            Log.d("aaaa", "111111!!!!!!!!!!!!!!!!!")
        }

        Log.d("aaaa", "222222!!!!!!!!!!!!!!!!!")
        //binding.viewModel = viewModel
        binding.lifecycleOwner = this

        /*
        CoroutineScope(Dispatchers.IO).launch {
            Database.getInstance(applicationContext).fatDao().insertFatEntity(FatEntity(id = 0, createDate = Date().time, updateDate = Date().time, weight = 75F))
        }
         */
    }
}
