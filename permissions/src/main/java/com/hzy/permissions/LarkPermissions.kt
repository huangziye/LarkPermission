package com.hzy.permissions

import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

/**
 * Created by ziye_huang on 2018/11/23.
 */
open class LarkPermissions {

    interface PermissionCallback {
        fun granted()

        fun denied()

        fun goSettings()
    }

    companion object {
        private const val TAG = "fragment"
        const val OK = 200
        fun requestPermission(activity: FragmentActivity, callback: PermissionCallback, vararg perms: String) {
            for (perm in perms) {
                if (ContextCompat.checkSelfPermission(activity, perm) != PackageManager.PERMISSION_GRANTED) {
                    var fragmentManager = activity.supportFragmentManager
                    var fragment = fragmentManager.findFragmentByTag(TAG)
                    if (fragment == null) {
                        fragment = HideFragment()
                        fragmentManager.beginTransaction().add(fragment, TAG).commitAllowingStateLoss()
                    }
                    fragmentManager.executePendingTransactions()
                    if (fragment is HideFragment) {
                        fragment.callback = callback
                        fragment.requestPermissions(perms, OK)
                    }
                    return
                }
            }
            callback?.granted()
        }

        fun hasAllPermissionsGranted(grantResults: IntArray): Boolean {
            for (grant in grantResults) {
                if (grant == PackageManager.PERMISSION_DENIED) {
                    return false
                }
            }
            return true
        }
    }

}