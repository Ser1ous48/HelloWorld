package com.pm.helloworld.data.repositorio

import androidx.lifecycle.LiveData
import com.pm.helloworld.data.dao.PrimeiraInterface
import com.pm.helloworld.data.entities.PrimeiraClasse

class ProductRepository(private  val productDao: PrimeiraInterface) {
    val readAllProducts : LiveData<List<PrimeiraClasse>> = productDao.readAllProducts()

    suspend fun addProduct(product: PrimeiraClasse){
        productDao.addProduct(product)
    }

    suspend fun updateProduct(product: PrimeiraClasse) {
        productDao.updateProduct(product)
    }

    suspend fun deleteProduct(product: PrimeiraClasse) {
        productDao.deleteProduct(product)
    }
}