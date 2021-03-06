# 微信红包


一个帮助你在微信抢红包时战无不胜的Android应用。自动检测并且拆开红包，速度超乎你的想象。

前往[**Release**](https://github.com/AnyMarvel/WeChatLuckyMoney/releases/)下载最新版本。(由于项目中无联网功能，暂不支持联网更新)

### 特性

- **监视选项任意组合，满足多样化的使用需求**

  提供了`系统通知`/`聊天列表`两档选项，无论是想要谨慎不被察觉，还是想要高效志在必得，这个插件如你所愿。

- **不仅快人一步，红包识别更加智能**

  多种特征标识，聊天时不再重复点击红包。智能过滤红包关键字，避免落入“专属红包”、“抢到翻倍”的陷阱。还可以设置延时抢红包。

- **紧跟微信更新**

  第一时间适配最新版本微信，应用内即可一键更新。

- **轻量、安全、值得信赖**

  安装包仅1M，无需ROOT，下载即用。代码公开透明，活跃的社区讨论，数万用户下载，值得你的信赖。

### 使用方法

1. 打开『微信红包』应用，开启插件。
2. 做你想做的事。
3. 坐等红包进账。

### **版权及免责声明**

本项目源自小米去年秋季发布会时演示的MIUI 7抢红包测试[代码](https://github.com/XiaoMi/LuckyMoneyTool)。

插件可能会在一定程度上改变微信的交互方式。使用本项目中包含的代码及其生成物时，使用者自行承担随之而来的各种风险，包括但不限于“禁用红包功能”、“微信封号”。

本项目使用[MIT许可证](https://github.com/AnyMarvel/WeChatLuckyMoney/blob/stable/LICENSE.md)。

### **增强功能说明**
红包新旧以send 发送者 text发送内容 time 发送时间 这三项内容为区分标准
微信在短时间内连续同一用户在同一聊天对话框中连续发送相同红包则会产生没有time这个textview的展示,则发送者和发送内容完全相同的情况下,发送时间为空,则默认为相同红包(bug)
目前在配置功能界面使用增强功能，每次获取最后一个红包不区分新旧，直接点开。（ps:这并不是一个好的解决方法，后续会研究解决）
此功能由于比较耗电，暂时关闭
