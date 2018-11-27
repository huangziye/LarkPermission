
[![](https://jitpack.io/v/huangziye/LarkPermission.svg)](https://jitpack.io/#huangziye/LarkPermission)

# Add ` LarkPermission ` to project

- Step 1：Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```android
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

- Step 2：Add the dependency

The latest version shall prevail.

```android
dependencies {
        implementation 'com.github.huangziye:LarkPermission:${latest_version}'
}
```

# How to use it in an Activity

### Kotlin

```
LarkPermissions.requestPermission(this,object:LarkPermissions.PermissionCallback{
    override fun denied() {
        Toast.makeText(this@MainActivity,"denied",Toast.LENGTH_SHORT).show()
    }

    override fun goSettings() {
        Toast.makeText(this@MainActivity,"goSettings",Toast.LENGTH_SHORT).show()
    }

    override fun granted() {
        Toast.makeText(this@MainActivity,"granted",Toast.LENGTH_SHORT).show()
    }
},android.Manifest.permission.CAMERA)
```

### Java

```
 LarkPermissions.Companion.requestPermission(this, new LarkPermissions.PermissionCallback() {
    @Override
    public void granted() {
        Toast.makeText(MainActivity.this,"granted",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void denied() {
        Toast.makeText(MainActivity.this,"denied",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goSettings() {
        Toast.makeText(MainActivity.this,"goSettings",Toast.LENGTH_SHORT).show();
    }
}, Manifest.permission.CAMERA);
```

# How to use it in a Fragment

### Kotlin


```
override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    Handler().postDelayed({
        LarkPermissions.requestPermission(activity!!, object : LarkPermissions.PermissionCallback {
            override fun granted() {
                Toast.makeText(activity!!, "granted", Toast.LENGTH_SHORT).show()
            }

            override fun denied() {
                Toast.makeText(activity!!, "denied", Toast.LENGTH_SHORT).show()
            }

            override fun goSettings() {
                Toast.makeText(activity!!, "goSettings", Toast.LENGTH_SHORT).show()
            }
        }, Manifest.permission.CAMERA)
    }, 10)

}
```

### Java

```
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        LarkPermissions.Companion.requestPermission(getActivity(), new LarkPermissions.PermissionCallback() {
            @Override
            public void granted() {
                Toast.makeText(getActivity(),"granted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void denied() {
                Toast.makeText(getActivity(),"denied",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void goSettings() {
                Toast.makeText(getActivity(),"goSettings",Toast.LENGTH_SHORT).show();
            }
        },Manifest.permission.CAMERA);
    }
},10);
```


# If you are developing in Java, you need to support Kotlin and AndroidX

### 1. gradle.properties

Support AndroidX

```
android.useAndroidX=true
android.enableJetifier=true
```

### 2. project/build.gradle

```
buildscript {
    ext.kotlin_version = '1.2.71'
    repositories {
        ...
    }
    dependencies {
        ...
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

### 3. app/build.gradle

```
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

...

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    ...
    implementation 'com.github.huangziye:LarkPermission:${latest_version}'
}

```



# About me


- [简书](https://user-gold-cdn.xitu.io/2018/7/26/164d5709442f7342)

- [掘金](https://juejin.im/user/5ad93382518825671547306b)

- [Github](https://github.com/huangziye)


# License

```
Copyright 2018, huangziye

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```



