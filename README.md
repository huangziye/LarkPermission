
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

```
findViewById<Button>(R.id.get_permission).setOnClickListener {
    LarkPermissions.requestPermission(this@MainActivity, object : LarkPermissions.PermissionCallback {
        override fun granted() {
            Toast.makeText(this@MainActivity, "granted", Toast.LENGTH_SHORT).show()
        }

        override fun denied() {
            Toast.makeText(this@MainActivity, "denied", Toast.LENGTH_SHORT).show()
        }

        override fun goSettings() {
            Toast.makeText(this@MainActivity, "goSettings", Toast.LENGTH_SHORT).show()
        }

    }, android.Manifest.permission.CAMERA)
}
```

# How to use it in a Fragment

```
findViewById<Button>(R.id.get_permission).setOnClickListener {
    LarkPermissions.requestPermission(activity, object : LarkPermissions.PermissionCallback {
        override fun granted() {
            Toast.makeText(activity, "granted", Toast.LENGTH_SHORT).show()
        }

        override fun denied() {
            Toast.makeText(activity, "denied", Toast.LENGTH_SHORT).show()
        }

        override fun goSettings() {
            Toast.makeText(activity, "goSettings", Toast.LENGTH_SHORT).show()
        }

    }, android.Manifest.permission.CAMERA)
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



