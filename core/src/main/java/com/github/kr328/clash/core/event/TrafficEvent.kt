package com.github.kr328.clash.core.event

import android.os.Parcel
import android.os.Parcelable
import com.github.kr328.clash.core.serialization.Parcels
import kotlinx.serialization.Serializable

@Serializable
data class TrafficEvent(val down: Long, val up: Long) : Event, Parcelable {
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        Parcels.dump(serializer(), this, parcel)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TrafficEvent> {
        override fun createFromParcel(parcel: Parcel): TrafficEvent {
            return Parcels.load(serializer(), parcel)
        }

        override fun newArray(size: Int): Array<TrafficEvent?> {
            return arrayOfNulls(size)
        }
    }
}