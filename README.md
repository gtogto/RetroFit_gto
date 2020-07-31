# Retrofit-tutorial

This is a sample project to show how to use Retrofit Libaray in your Android App.

- Java based
- use Android X 
- use databinding


## Used Libaray (사용한 라이브러리)

- [Retrofit](https://square.github.io/retrofit)
- [JSONPlaceholder](http://jsonplaceholder.typicode.com)

```groovy
dependencies {
    implementation 'com.squareup.retrofit2:retrofit:2.6.1'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.1'
}
```

## Detail

1. MainActivity : just test Acitivty
2. RetroClient : create Retrofit instance and apiService. then networking 
3. RetroCallback : received data and pass UI thread
4. RetroBaseApiService : The api to access JSONPlaceholder
5. RequestPut : request form in put method
6. ResponseGet : received form in get method

NOTE

- Add Internet permission in AndroidManifest.xml
- (Android Q) add network_security_config.xml
```
<uses-permission android:name="android.permission.INTERNET"/>
```

## ScreenShot
![Output Image](https://user-images.githubusercontent.com/30851459/88996161-85313000-d327-11ea-9566-b3552fd5001d.jpg)
