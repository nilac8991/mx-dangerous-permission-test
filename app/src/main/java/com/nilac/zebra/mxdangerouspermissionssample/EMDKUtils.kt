package com.nilac.zebra.mxdangerouspermissionssample

import android.content.Context
import android.util.Log
import com.zebra.nilac.emdkloader.EMDKLoader
import com.zebra.nilac.emdkloader.interfaces.EMDKManagerInitCallBack

object EMDKUtils {

    private const val TAG = "EMDKUtils"
    fun initEMDKManager(context: Context, callBack: EMDKManagerInitCallBack) {
        Log.i(TAG, "Initialising EMDK Manager")
        EMDKLoader.getInstance().initEMDKManager(context, callBack)
    }
}