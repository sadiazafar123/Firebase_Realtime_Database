package com.example.firebaserealtimedatabase.models

import android.os.Parcel
import android.os.Parcelable


data class UserInfo(
    val id: String?="",

    val name: String?="",

    val fname: String?="",

    val email:String?="",

    val phoneNo: Long=0,
    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readLong()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(fname)
        parcel.writeString(email)
        parcel.writeLong(phoneNo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserInfo> {
        override fun createFromParcel(parcel: Parcel): UserInfo {
            return UserInfo(parcel)
        }

        override fun newArray(size: Int): Array<UserInfo?> {
            return arrayOfNulls(size)
        }
    }
}

