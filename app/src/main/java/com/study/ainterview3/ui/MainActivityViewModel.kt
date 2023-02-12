package com.study.ainterview3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.ainterview3.domain.model.Fox
import com.study.ainterview3.domain.repository.FoxRepository
import com.study.ainterview3.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val foxRepository: FoxRepository
): ViewModel() {

    private val _foxData : MutableLiveData<Resource<Fox>> = MutableLiveData()
    val foxData : LiveData<Resource<Fox>> = _foxData

    private val _isLoading : MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading :LiveData<Boolean> = _isLoading


    init {
        getFox()
    }

    fun getFox(){
        viewModelScope.launch {
            _foxData.value = foxRepository.getFox()
            _isLoading.value = false
        }
    }


}