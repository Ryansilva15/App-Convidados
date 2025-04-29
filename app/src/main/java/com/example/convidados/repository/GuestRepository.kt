package com.example.convidados.repository

import android.content.ContentValues
import com.example.convidados.Model.GuestModel
import android.database.sqlite.SQLiteDatabase
import com.example.convidados.constants.DataBaseConstants

private val SQLiteDatabase.writableDatabase: Any
    get() {
        TODO("Not yet implemented")
    }

class GuestRepository private constructor() {

    private lateinit var guestDataBase: SQLiteDatabase

    // Padrão Singleton
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(guestDataBase: SQLiteDatabase): GuestRepository {
            if (!Companion::repository.isInitialized) {
                repository = GuestRepository()
                repository.guestDataBase = guestDataBase // Inicializa o banco de dados
            }
            return repository
        }

        fun getInstance() {

        }
    }


    fun insert(guest: GuestModel): Boolean { // Função para inserir um convidado no banco de dados
        try {
            val db = guestDataBase.writableDatabase
            val presence = if (guest.presence) 1 else 0

            val values = ContentValues().apply {
                put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)
                put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            }

            db.insert(DataBaseConstants.GUEST.COLUMNS.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            true

        }
        return TODO("Provide the return value")
    }
}

private fun Any.insert(s: String, nothing: Nothing?, values: ContentValues) {


}
