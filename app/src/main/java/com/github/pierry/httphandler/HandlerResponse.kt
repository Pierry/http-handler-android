package com.github.pierry.httphandler

import android.content.Context
import android.content.res.Configuration
import java.net.HttpURLConnection
import java.util.*

class HandlerResponse {

  fun language(context: Context, language: String) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val res = context.resources
    val config = Configuration(res.configuration)
    config.locale = locale
    res.updateConfiguration(config, res.displayMetrics)
  }

  fun handle(code: Int): Handled {
    when (code) {
      HttpURLConnection.HTTP_UNAUTHORIZED -> return unauthorized(code)
      HttpURLConnection.HTTP_FORBIDDEN -> return forbidden(code)
      HttpURLConnection.HTTP_NOT_FOUND -> return notFound(code)
//      HttpURLConnection.HTTP_NO_CONTENT -> noContent()
//      HttpURLConnection.HTTP_BAD_GATEWAY -> badGateway()
//      HttpURLConnection.HTTP_BAD_REQUEST -> badRequest()
//      HttpURLConnection.HTTP_CONFLICT -> conflict()
      else -> return Handled(code, R.string.unknown)
    }
  }

  private fun unauthorized(code: Int) = Handled(code, R.string.unauthorized)

  fun forbidden(code: Int) = Handled(code, R.string.forbidden)

  fun notFound(code: Int) = Handled(code, R.string.forbidden)

  fun noContent() {

  }

  fun badGateway() {

  }

  fun badRequest() {

  }

  fun conflict() {

  }
}