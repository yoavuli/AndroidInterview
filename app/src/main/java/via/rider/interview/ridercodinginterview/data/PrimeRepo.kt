package via.rider.interview.ridercodinginterview.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import via.rider.interview.ridercodinginterview.prime.isPrime

class PrimeRepo() : PagingSource<Int, PrimeData>() {


    // this is a cache for the last prime value and index. in the Prime list exercise
    // the last LoadParams key field is the same as the last item in the previous load call
    // it's a bit of abusing the paging source mechanism but due to the caching done in the
    // viewmodel scope the lastCachedPrime is enough.
    private var lastCachedPrime: PrimeData = PrimeData(0,0)


    override fun getRefreshKey(state: PagingState<Int, PrimeData>): Int? {

        // in the prime list exercise case the anchor position is the last key and will always go up
        return state.anchorPosition?.let { anchorPosition ->
            val closestPageToPosition = state.closestPageToPosition(anchorPosition)
            closestPageToPosition?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PrimeData> {

        // prevent infinite loop of start value
        if (params.key == null) return LoadResult.Page(emptyList(),null,0)

        val nextIndex = params.key ?: 0
        val list = getPrimeList(lastCachedPrime, params.loadSize)
        lastCachedPrime = list.last()

        return LoadResult.Page(
            data = list,
            prevKey = nextIndex,
            nextKey = nextIndex + params.loadSize)
    }


    // this is the basic logic for finding the prime number in the list.
    // some optimization could have been done to improve the algorithm
    // (increment currentValue by 2 to avoid even numbers. "2" is a spacial case)
    private fun getPrimeList(lastPrime: PrimeData, count: Int = 0): List<PrimeData> {

        val list = mutableListOf<PrimeData>()
        val indexOffset = lastPrime.index + 1
        var currentValue = lastPrime.value + 1

        while (list.size < count) {
            if (currentValue.isPrime) { list.add(PrimeData(
                value = currentValue,
                index = indexOffset + list.size)) }
            currentValue++
        }
        return list
    }




}