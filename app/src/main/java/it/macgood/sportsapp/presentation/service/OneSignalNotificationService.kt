package it.macgood.sportsapp.presentation.service

import android.content.Context
import android.content.Intent
import com.onesignal.OSNotificationAction
import com.onesignal.OSNotificationOpenedResult
import com.onesignal.OneSignal
import dagger.hilt.android.qualifiers.ApplicationContext
import it.macgood.sportsapp.presentation.MainActivity
import javax.inject.Inject
import javax.inject.Singleton

const val EXTRAS_NOTIFICATION_URL_KEY = "url"

@Singleton
class OneSignalNotificationService @Inject constructor() : OneSignal.OSNotificationOpenedHandler {

    @ApplicationContext
    lateinit var context: Context

    override fun notificationOpened(result: OSNotificationOpenedResult?) {
        if (result != null) {
            val actionType = result.action.type
            val data = result.notification.additionalData
            if (data != null) {
                val url = data.optString("url")

                if (actionType == OSNotificationAction.ActionType.ActionTaken) {
                    val intent = Intent(context, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    intent.putExtra(EXTRAS_NOTIFICATION_URL_KEY, url)
                    context.startActivity(intent)
                }
            }
        }
    }
}