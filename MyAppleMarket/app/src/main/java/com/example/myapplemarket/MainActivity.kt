package com.example.myapplemarket

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.myapplemarket.databinding.ActivityMainBinding
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : AppCompatActivity() {

    private  lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain)
        supportActionBar!!.title = "봉선동"



        binding.toolbarMain.setOnMenuItemClickListener { menuItem ->
            if(menuItem.itemId == R.id.item_notification) { //알림버튼이 눌렸을 때
                Toast.makeText(this,"알림기능 추가예정",Toast.LENGTH_SHORT).show()
                true
            }
            else false
        }
    }
    // 메뉴 리소스 XML의 내용을 앱바(App Bar)에 반영
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }
}