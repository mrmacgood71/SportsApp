package it.macgood.sportsapp

import android.app.Application
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp
import it.macgood.sportsapp.presentation.service.OneSignalNotificationService


const val ONESIGNAL_APP_ID = "6b4ee6e7-676b-465f-9553-f7b156eac233"

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.setNotificationOpenedHandler(OneSignalNotificationService())
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.promptForPushNotifications()
    }

}