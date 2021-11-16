package com.pm.helloworld.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pm.helloworld.data.database.PrimeiraDatabase
import com.pm.helloworld.data.entities.PrimeiraClasse
import com.pm.helloworld.data.repositorio.ProductRepository
import com.pm.helloworld.data.dao.PrimeiraInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application){
    val readAllProducts: LiveData<List<PrimeiraClasse>>
    private val repository: ProductRepository

    init {
        val productDao = PrimeiraDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        readAllProducts = repository.readAllProducts
    }

    fun  addProduct(product: PrimeiraClasse){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(product)
        }
    }

    fun updateProduct(product: PrimeiraClasse) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProduct(product)
        }
    }

    fun  deleteProduct(product: PrimeiraClasse) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProduct(product)
        }
    }
}