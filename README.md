# GsonNullEscape

### 项目作用主要用于GSON解析服务器返回的各种数据类型为NUll，Boolean为0,1，null，等等的判断并替换为正常的数据保障json转实体的时候不报错

很多年前，我解析Gson时拿服务器返回的String发现是null，解析出错,然后写了这篇文章[《Gson解析null替换为空字符串》](https://www.jianshu.com/p/c6dd9a6b10ee)

最近几个月因为新项目想用MVVM来架构，所以找了很多框架，最后发现这个[框架](https://github.com/wzqjava/MVVMSmart)还不错，因为看到对方在解析网络数据的时候
封装了一些null的判断，所以用在生产上绝对是可靠的，很多快速开发框架压根都不处理null的解析问题，这让我很诧异。

### 所以如果你需要快速开发，用MVVM框架搭建app，我推荐用https://github.com/wzqjava/MVVMSmart ，
当然后面我自己加了一些功能提交了pull 分支了 https://github.com/hloong/MVVMSmart ，这个Gson解析的就是从框架抽出来的

具体使用很简单,示例代码如下

如果你用于自己项目，只需要集成Gson，然后从本项目拷贝 GsonUtil.java和 gsontypeadapter这个文件夹里的文件,就可以用了

```
//实体类
data class TestGson(
    @SerializedName("error")
    var error: String = "",
    @SerializedName("message")
    var message: Long =0,
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("success")
    var success: Boolean = false,
    @SerializedName("timestamp")
    var timestamp:Double=0.0,
    @SerializedName("type")
    var type: Float = 0f
)
//解析
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

```

