package com.example.convidados.constants

class DataBaseConstants private constructor() {

     object GUEST{
        const val TABLE_NAME = "Guest"

         object COLUMNS {
             val TABLE_NAME: String
                 get() {
                     TODO()
                 }

             const val ID = "id"
             const val NAME = "Guest"
             const val PRESENCE = "Presence"
         }
    }
}