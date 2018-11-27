package com.hzy.larkpermission

import android.Manifest
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hzy.permissions.LarkPermissions

/**
 * Created by ziye_huang on 2018/11/27.
 */
class TestFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

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
}