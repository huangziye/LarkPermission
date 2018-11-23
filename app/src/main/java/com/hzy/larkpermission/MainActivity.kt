package com.hzy.larkpermission

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hzy.permissions.LarkPermissions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}
