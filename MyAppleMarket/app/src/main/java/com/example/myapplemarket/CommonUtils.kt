package com.example.myapplemarket
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import androidx.core.app.NotificationCompat
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService
import java.text.NumberFormat
import java.util.*

fun formatPrice(price: Int): String { // 천 단위로 콤마(,) 찍어 표시
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return formatter.format(price)
}

@SuppressLint("NotificationPermission")
fun notification(context: Context) {
    val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

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
        builder = NotificationCompat.Builder(context, channelId)
    } else { //8.0 이하
        // 26 버전 이하
        builder = NotificationCompat.Builder(context)
    }
    // 알림의 기본 정보
    builder.run {
        setSmallIcon(R.mipmap.ic_launcher) // 아이콘 설정
        setWhen(System.currentTimeMillis()) // 알람 발생 시간 (현재시간)
        setContentTitle("키워드 알림")
        setContentText("설정한 키워드에 대한 알림이 도착했습니다.")
//        setStyle(
//            NotificationCompat.BigTextStyle()
//                .bigText("이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다.  아주 긴 텍스트를 쓸때는 여기다 하면 됩니다 . 이것은 긴텍스트 샘플입니다 . 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다 ."))
    }
    manager.notify(11, builder.build())
}