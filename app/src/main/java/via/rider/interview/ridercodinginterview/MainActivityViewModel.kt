package via.rider.interview.ridercodinginterview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import via.rider.interview.ridercodinginterview.data.PrimeRepo

class MainActivityViewModel: ViewModel() {


    val primeFlow = Pager (
        PagingConfig(25))
    { PrimeRepo() }.flow.cachedIn(viewModelScope)


}