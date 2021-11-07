package com.pm.helloworld.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pm.helloworld.data.entities.PrimeiraClasse

@Dao
interface PrimeiraInterface {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProduct(product: PrimeiraClasse)

    @Update
    fun updateProduct(product: PrimeiraClasse)

    @Query("SELECT * FROM product ORDER BY id DESC")
    fun readAllProducts(): LiveData<List<PrimeiraClasse>>

    @Delete
    fun deleteProduct(product: PrimeiraClasse)
}