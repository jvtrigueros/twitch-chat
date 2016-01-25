package club.guacamoledragon.plugin.kapchat

import org.json.JSONObject
import java.awt.Color


data class KapChatMessage(val nick: String, val message: String, val emotes: String, val userData: UserData) {

    companion object {
        fun parse(data: JSONObject): KapChatMessage {
            val message = data.optString("message")
            val nick = data.optString("nick")

            val emotes = data.optString("emotes") // TODO: Parse into a list of emotes

            val color = Color.decode(data.optString("color", "#FFFFFF"))
            val displayName = data.optString("displayName")

            /* TODO: Use when needed.
            val subscriber = data.optBoolean("subscriber")
            val turbo = data.optBoolean("turbo")
            val userType = data.optString("userType")
            */

            return KapChatMessage(nick, message, emotes, UserData(color, displayName))
        }
    }
}

data class UserData(val color: Color, val displayName: String)
