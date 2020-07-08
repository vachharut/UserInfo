package info.user.users

import android.os.Parcelable
import info.user.api.User
import kotlinx.android.parcel.Parcelize

typealias UserModelList = List<UserModel>

@Parcelize
data class UserModel(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
) : Parcelable

fun User.toUserModel() = UserModel(
    id = id,
    name = name,
    email = email,
    phone = phone
)
