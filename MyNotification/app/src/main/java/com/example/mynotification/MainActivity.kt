package com.example.mynotification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.mynotification.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notificationButton.setOnClickListener {
            notification()
        }
    }

    @SuppressLint("NotificationPermission")
    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 8.0 이상인지 체크
            // 26 버전 이상
            val channelId = "one-channel"  // 채널 ID
            val channelName = "My Channel One" // 채널 이름
            val channel = NotificationChannel( // 채널을 만듬
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                // 채널에 다양한 정보 설정
                description = "My Channel One Description" // Description
                setShowBadge(true) // 배찌
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION) //알람 소리 넣기
                val audioAttributes = AudioAttributes.Builder() //오디오 선언 -> 지금은 Android기본 사운드
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes) // 사운드에 오디오를 넣어줌
                enableVibration(true) // 진동을 넣어줌
            }
            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId)

        } else { //8.0 이하
            // 26 버전 이하
            builder = NotificationCompat.Builder(this)
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.flower) //사진받아옴
        val intent = Intent(this, SecondActivity::class.java) // 인텐트 하나 생성
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        // 알림의 기본 정보
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher) // 아이콘 설정
            setWhen(System.currentTimeMillis()) // 알람 발생 시간 (현재시간)
            setContentTitle("새로운 알림입니다.")
            setContentText("알림이 잘 보이시나요.")
            setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다.  아주 긴 텍스트를 쓸때는 여기다 하면 됩니다 . 이것은 긴텍스트 샘플입니다 . 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다 ."))
            setLargeIcon (bitmap) //사진을 넣어줌
            setStyle(NotificationCompat.BigPictureStyle() // 사진을 크게
                    .bigPicture(bitmap)
                    .bigLargeIcon(null))  // hide largeIcon while expanding
            addAction (R.mipmap.ic_launcher, "Action", pendingIntent) // 클릭 시 두 번째 액티비티 실행
        }


        manager.notify(11, builder.build())
    }
}