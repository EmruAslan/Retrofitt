package com.example.retrofitt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitt.Utils.RetrofitInstance
import com.example.retrofitt.databinding.ActivityMainBinding
import com.example.retrofitt.models.UsersItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var userList: List<UsersItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userList = listOf()

        GlobalScope.launch(Dispatchers.IO) {
            val response = try {
                RetrofitInstance.api.getAllUsers()
            } catch (e: IOException) {
                Toast.makeText(applicationContext, "app error ${e.message}", Toast.LENGTH_LONG)
                    .show()
                return@launch
            } catch (e: HttpException) {
                Toast.makeText(applicationContext, "http error ${e.message}", Toast.LENGTH_LONG)
                    .show()
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                withContext(Dispatchers.Main) {
                    userList = response.body()!!
                    binding.rvMain.apply {
                        rvAdapter = RvAdapter(userList)
                        adapter = rvAdapter
                        layoutManager = LinearLayoutManager(context)
                    }
                }
            }


        }
    }
}