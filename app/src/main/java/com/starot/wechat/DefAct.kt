package com.starot.wechat

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.starot.larger.activity.LargerAct
import com.starot.larger.bean.ImageInfo
import com.starot.larger.tools.ImageTool
import com.starot.wechat.larger.DefLargerAct
import kotlinx.android.synthetic.main.activity_def.*

class DefAct : AppCompatActivity() {
    private val imageViews by lazy {
        arrayListOf<ImageView>(
            image_1,
            image_2,
            image_3,
            image_4,
            image_5,
            image_6,
            image_7,
            image_8
        )
    }
    private val images = arrayListOf(
        "http://img.netbian.com/file/2019/0722/46a77e637238b439e445a8e11279eb28.jpg",
        "http://img.netbian.com/file/2019/1214/552b1999aa4d5a2e75352fa2f6e93d51.jpg",
        "http://img.netbian.com/file/2020/0628/60cb9c1b9c5fecdb8ffe1e686ca7ef1d.jpg",
        "http://pic.jj20.com/up/allimg/1111/0H91Q05918/1PH9105918-1-1200.jpg",
        "http://pic.jj20.com/up/allimg/1111/0H91Q05918/1PH9105918-1-1200.jpg",
        "http://pic.jj20.com/up/allimg/1111/0H91Q05918/1PH9105918-1-1200.jpg",
        "http://pic.jj20.com/up/allimg/1111/0H91Q05918/1PH9105918-1-1200.jpg",
        "http://pic1.win4000.com/mobile/2020-06-12/5ee33a090097d.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_def)



        for (index in imageViews.indices) {
            imageViews[index].scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(this)
                .load(images[index])
                .into(imageViews[index])
            imageViews[index].setOnClickListener {
                startAct(index, images, getInfo())
            }
        }
    }

    private fun getInfo(): ArrayList<ImageInfo> {
        val info = arrayListOf<ImageInfo>()
        for (index in imageViews.indices) {
            info.add(ImageTool.getImageInfo(imageViews[index]))
        }
        return info
    }

    private fun startAct(
        index: Int,
        images: ArrayList<String>,
        info: ArrayList<ImageInfo>
    ) {
        val intent = Intent(this, DefLargerAct::class.java)
        //传入图片信息 这里可所以类型
        intent.putStringArrayListExtra(LargerAct.IMAGE, images)
        //传入当前的 index  用于处理viewpager2 务必添加
        intent.putExtra(LargerAct.INDEX, index)
        //传入图片的位置信息，点击以后的动画效果需要 务必添加
        intent.putParcelableArrayListExtra(
            LargerAct.ORIGINAL,
            info
        )
        startActivity(intent)
    }
}