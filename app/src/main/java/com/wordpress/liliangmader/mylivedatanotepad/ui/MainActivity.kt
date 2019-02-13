package com.wordpress.liliangmader.mylivedatanotepad.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.wordpress.liliangmader.mylivedatanotepad.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.nav_host_fragment).navigateUp()

}


//references for this app
//https://medium.com/@kirillsuslov/how-to-start-using-room-b90d08eb3f0b
//https://resocoder.com/2018/09/07/mvvm-on-android-crash-course-kotlin-android-architecture-components/
//https://www.youtube.com/watch?v=0cg09tlAAQ0&t=65s
//https://medium.com/mindorks/android-architecture-components-room-viewmodel-and-livedata-50611793e4a9
//https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/index.html?index=..%2F..index#13