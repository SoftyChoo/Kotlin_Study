package com.example.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.myfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            fragment1Btn.setOnClickListener{ // 첫 번째 버튼이 눌렸을 때
                setFragment(FirstFragment()) // 첫 번째 프래그먼트로 설정
            }
            fragment2Btn.setOnClickListener {// 두 번째 버튼이 눌렸을 때
                setFragment(SecondFragment()) // 두 번째 프래그먼트로 설정
            }
        }
        setFragment(FirstFragment()) // 앱 실행 시 기본 프래그먼트를 띄워줌
    }

    private fun setFragment(frag : Fragment) { // 프래그먼트를 받아옴
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag) // 반아온 프래그먼트로 전환시켜줌 [Framelayout]에 frag 변수에 들어온 프래그먼트를 띄워줌
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}