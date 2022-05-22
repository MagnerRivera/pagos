package com.example.pagos.utils

import android.os.Build
import android.util.Log
import com.example.pagos.data.APIConstants
import com.google.common.hash.Hashing
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.log

fun getRandom(): String {
    return BigInteger(130, SecureRandom()).toString()
}

fun getCurrentDateFormat(): String {
    return SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ssXXX",
        Locale.getDefault()
    ).format(Date())
}

fun getBase64(input: ByteArray): String {
    val encodedBytes: ByteArray = if (Build.VERSION.SDK_INT >=
        Build.VERSION_CODES.O
    ) {
        Base64.getEncoder().encode(input)
    } else {
        android.util.Base64.encode(input, android.util.Base64.NO_WRAP)
    }
    return String(encodedBytes)
}

fun getSHA256(input: String): ByteArray {
    val mDigest: MessageDigest = MessageDigest.getInstance("SHA-256")
    return mDigest.digest(input.toByteArray())
}
fun getSHA2562(input: String): String {
    return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString()
}

fun generate(login: String, tranKey: String): Map<String, String> {
    val nonce = getRandom();
    val seed = getCurrentDateFormat();
    val sha = getSHA256(
        nonce + seed +
                tranKey
    )
    Log.e("TAG", "seed: $seed ")
    Log.e("TAG", "transKey: $tranKey " )
    Log.e("TAG", "sha: $sha" )
    Log.e("TAG", "nonce: $nonce " )
    Log.e("TAG", "nonce: ${nonce.toByteArray()} " )
    val digest =
        getBase64(
            getSHA2562(
                nonce + seed +
                        tranKey
            ).toByteArray()
        )
    return mapOf(
        "login" to login,
        "tranKey" to digest,
        "nonce" to getBase64(nonce.toByteArray()),
        "seed" to seed
    )
}