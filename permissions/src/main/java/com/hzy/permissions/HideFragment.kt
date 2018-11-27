package com.hzy.permissions

import android.app.Activity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

/**
 * Created by ziye_huang on 2018/11/23.
 */
open class HideFragment : Fragment() {

    var callback: LarkPermissions.PermissionCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //禁止横竖屏切换时的Fragment的重建
        retainInstance = true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LarkPermissions.OK) {
            if (LarkPermissions.hasAllPermissionsGranted(grantResults)) {
                callback?.granted()
            } else {
                for (permission in permissions) {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(activity as Activity, permission)) {
                        callback?.goSettings()
                        return
                    } else {
                        callback?.denied()
                    }
                }
            }
        }
    }
}
