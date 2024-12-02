package com.nilac.zebra.mxdangerouspermissionssample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.symbol.emdk.EMDKResults
import com.zebra.nilac.emdkloader.EMDKLoader
import com.zebra.nilac.emdkloader.ProfileLoader
import com.zebra.nilac.emdkloader.interfaces.EMDKManagerInitCallBack
import com.zebra.nilac.emdkloader.interfaces.ProfileLoaderResultCallback
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        EMDKUtils.initEMDKManager(this, object : EMDKManagerInitCallBack {
            override fun onFailed(message: String) {
                Log.e(TAG, "Failed to initialise EMDK Manager")
            }

            override fun onSuccess() {
                Log.i(TAG, "EMDK Manager was successfully initialised")
                processProfile()
            }
        })
        finishAffinity()
    }

    override fun onDestroy() {
        super.onDestroy()
        EMDKLoader.getInstance().release()
    }

    private fun processProfile() {
        ProfileLoader().processProfile("DangerousPermissions", null,
            object : ProfileLoaderResultCallback {
                override fun onProfileLoadFailed(errorObject: EMDKResults) {
                    //Nothing to see here..
                }

                override fun onProfileLoadFailed(message: String) {
                    Log.e(TAG, "Failed to process wifi profile")
                }

                override fun onProfileLoaded() {
                    Log.i(TAG, "Successfully processed profile")
                    finishAffinity()
                }
            })
    }

    companion object {
        const val TAG = "MainActivity"
    }
}