package com.hloong.gsonnullescape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    private fun initData(){
        // 测试当boolean返回0动态替换false，1动态替换true，返回null替换false
        var json  = "{\n" +
                "\t\"status\": 0.0,\n" +
                "\t\"message\": null,\n" +
                "\t\"error\": null,\n" +
                "\t\"type\": \"1\",\n" +
                "\t\"success\": null,\n" +
                "\t\"timestamp\": \"0\"\n" +
                "}"

        tv_default.text = json

        val data = GsonUtil.gson2Bean(json,TestGson::class.java)

        val gson =  "gsonNull解析==status==="+data.status+
                "\n===error==="+data.error+
                "\n===message===" +data.message+
                "\n===success==="+data.success+
                "\n===timestamp==="+data.timestamp+
                "\n===type==="+data.type

        tv_gson_null.text = gson
    }
}